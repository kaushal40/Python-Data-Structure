# System Design Cheatsheet

## Basic Steps

1) **Clarify and agree on the scope of the system**
* **User cases** (description of sequences of events that, taken together, lead to a system doing something useful)
	* Who is going to use it?
	* How are they going to use it?
* **Constraints** 
	* Mainly identify **traffic and data handling** constraints at scale.
	* Scale of the system such as requests per second, requests types, data written per second, data read per second)
	* Special system requirements such as multi-threading, read or write oriented.
	
2) **High level architecture design (Abstract design)**
* Sketch the important components and connections between them, but don't go into some details.
	* Application service layer (serves the requests)
	* List different services required.
   	* Data Storage layer
   	* eg. Usually a scalable system includes webserver (load balancer), service (service partition), database (master/slave database cluster) and caching systems.

3) **Component Design**
* Component + specific **APIs** required for each of them.
* **Object oriented design** for functionalities.
	* Map features to modules: One scenario for one module.
	* Consider the relationships among modules: 
		* Certain functions must have unique instance (Singletons)
		* Core object can be made up of many other objects (composition).
		* One object is another object (inheritance)
* **Database schema design.**

4) **Understanding Bottlenecks**
* Perhaps your system needs a load balancer and many machines behind it to handle the user requests. * Or maybe the data is so huge that you need to distribute your database on multiple machines. What are some of the downsides that occur from doing that? 
* Is the database too slow and does it need some in-memory caching?	

5) **Scaling** your abstract design
* **Vertical scaling**
	* You scale by adding more power (CPU, RAM) to your existing machine.
* **Horizontal scaling**
	* You scale by adding more machines into your pool of resources. 
* **Caching**
	* Load balancing helps you scale horizontally across an ever-increasing number of servers, but caching will enable you to make vastly better use of the resources you already have, as well as making otherwise unattainable product requirements feasible. 
	* **Application caching** requires explicit integration in the application code itself. Usually it will check if a value is in the cache; if not, retrieve the value from the database.
	* **Database caching** tends to be "free". When you flip your database on, you're going to get some level of default configuration which will provide some degree of caching and performance. Those initial settings will be optimized for a generic usecase, and by tweaking them to your system's access patterns you can generally squeeze a great deal of performance improvement.
	* **In-memory caches** are most potent in terms of raw performance. This is because they store their entire set of data in memory and accesses to RAM are orders of magnitude faster than those to disk. eg. Memcached or Redis.
	* eg. Precalculating results (e.g. the number of visits from each referring domain for the previous day), 
	* eg. Pre-generating expensive indexes (e.g. suggested stories based on a user's click history)
	* eg. Storing copies of frequently accessed data in a faster backend (e.g. Memcache instead of PostgreSQL.
* **Load balancing**
	* Public servers of a scalable web service are hidden behind a load balancer.  This load balancer evenly distributes load (requests from your users) onto your group/cluster of  application servers.
	* Types: Smart client (hard to get it perfect), Hardware load balancers ($$$ but reliable), Software load balancers (hybrid - works for most systems)

<p align="center">
  <img src="http://lethain.com/static/blog/intro_arch/load_balance.png" alt="Load Balancing"/>
</p>

* **Database replication**
	* Database replication is the frequent electronic copying data from a database in one computer or server to a database in another so that all users share the same level of information. The result is a distributed database in which users can access data relevant to their tasks without interfering with the work of others. The implementation of database replication for the purpose of eliminating data ambiguity or inconsistency among users is known as normalization.
* **Database partitioning**
	* Partitioning of relational data usually refers to decomposing your tables either row-wise (horizontally) or column-wise (vertically).
* **Map-Reduce**
	* For sufficiently small systems you can often get away with adhoc queries on a SQL database, but that approach may not scale up trivially once the quantity of data stored or write-load requires sharding your database, and will usually require dedicated slaves for the purpose of performing these queries (at which point, maybe you'd rather use a system designed for analyzing large quantities of data, rather than fighting your database). 
	* Adding a map-reduce layer makes it possible to perform data and/or processing intensive operations in a reasonable amount of time. You might use it for calculating suggested users in a social graph, or for generating analytics reports. eg. Hadoop, and maybe Hive or HBase.
* **Platform Layer (Services)**
	* Separating the platform and web application allow you to scale the pieces independently. If you add a new API, you can add platform servers without adding unnecessary capacity for your web application tier.
	* Adding a platform layer can be a way to reuse your infrastructure for multiple products or interfaces (a web application, an API, an iPhone app, etc) without writing too much redundant boilerplate code for dealing with caches, databases, etc.

<p align="center">
  <img src="http://lethain.com/static/blog/intro_arch/platform_layer.png" alt="Platform Layer"/>
</p>
	
## Key topics for designing a system

1) **Concurrency** 
* Do you understand threads, deadlock, and starvation? Do you know how to parallelize algorithms? Do you understand consistency and coherence?

2) **Networking**
* Do you roughly understand IPC and TCP/IP? Do you know the difference between throughput and latency, and when each is the relevant factor?

3) **Abstraction**
* You should understand the systems you’re building upon. Do you know roughly how an OS, file system, and database work? Do you know about the various levels of caching in a modern OS?

4) **Real-World Performance**
* You should be familiar with the speed of everything your computer can do, including the relative performance of RAM, disk, SSD and your network.

5) **Estimation**
* Estimation, especially in the form of a back-of-the-envelope calculation, is important because it helps you narrow down the list of possible solutions to only the ones that are feasible. Then you have only a few prototypes or micro-benchmarks to write.	

6) **Availability & Reliability**
*  Are you thinking about how things can fail, especially in a distributed environment? Do know how to design a system to cope with network failures? Do you understand durability?


## Web App System design considerations:
* Security (CORS)
* Using CDN
	* A content delivery network (CDN) is a system of distributed servers (network) that deliver webpages and other Web content to a user based on the geographic locations of the user, the origin of the webpage and a content delivery server.
	* This service is effective in speeding the delivery of content of websites with high traffic and websites that have global reach. The closer the CDN server is to the user geographically, the faster the content will be delivered to the user. 
	* CDNs also provide protection from large surges in traffic.
* Full Text Search
	* Using Sphinx/Lucene/Solr - which achieve fast search responses because, instead of searching the text directly, it searches an index instead.
* Offline support/Progressive enhancement
	* Service Workers
* Web Workers
* Server Side rendering
* Asynchronous loading of assets (Lazy load items)
* Minimizing network requests (Http2 + bundling/sprites etc)
* Developer productivity/Tooling
* Accessibility
* Internationalization
* Responsive design
* Browser compatibility

## Working Components of Front-end Architecture
* Code
  * HTML5/WAI-ARIA
  * CSS/Sass Code standards and organization
  * Object-Oriented approach (how do objects break down and get put together)
  * JS frameworks/organization/performance optimization techniques
  * Asset Delivery - Front-end Ops
* Documentation
  * Onboarding Docs
  * Styleguide/Pattern Library
  * Architecture Diagrams (code flow, tool chain)
* Testing
  * Performance Testing
  * Visual Regression
  * Unit Testing
  * End-to-End Testing
* Process
  * Git Workflow
  * Dependency Management (npm, Bundler, Bower)
  * Build Systems (Grunt/Gulp)
  * Deploy Process
  * Continuous Integration (Travis CI, Jenkins)







**Syatem Design High level**

- ask for what features the system can have
- scalable web application, start with single server system
- Add load balancers, multiple web app servers, multiple cache, multiple DB, task queue for quick response, Data peocessing in DB layer

![alt text](images/systemdesign_1.png "Title")
![alt text](images/systemdesign_2.png "Title")

-----
-----

**Approaching System design interview questions**

- (F) Define two or three core features for the system
- (U) UseCases - what are the different API's needed to achieve some features
- (S) Store  -  what to store, not the DB models. For example. customer profile, driver profile, customer state, driver state
- (H) High level design
- (D) Detailed level design

----

**System Design High Level UBER/LYFT**

- (F)
1. Users and Drivers
2. Hail ride (find and complete)

- (U)
1. Rider - Request a ride,  Get ETA,  Ride to Destinition, END ride
2. Driver - Accept/reject, Pickup Passender, Drive, End ride
3. Create workflow for the features

![alt text](images/systemdesign_3.png "Title")
![alt text](images/systemdesign_4.png "Title")


------
------

**LOAD BALANCER**

![alt text](images/loadb_1.png "Title")

![alt text](images/loadb_2.png "Title")

![alt text](images/loadb_3.png "Title")

![alt text](images/loadb_4.png "Title")

------
------

**SHRADING**

- it's splitting db in small pieces and find some way (logic) to make it work togather - find what piece is where
- What can be shradded? 
1. Distributed Database
2. Distributed Cache - Memcached is a high-performance, distributed caching system. Although application-neutral, it's most commonly used to speed up dynamic Web applications by alleviating database load
[Memchche article](linuxjournal.com/article/7451)
![alt text](images/memcahce.jpg "Title")
3. Distributed Hash Table
4. Distributed Key-Value Stores

**CAP THEOREM**

*ACID*
- ACID DBs are Consistent and Base DBs are Eventually Consistent
- Atomic - Everything in the write/update succeeds or the entire operation is rolled back
- Consistent - The database will never be in a state where two reads to the same DB get different value.
- Isolated - Operations cannot interfere with each other.
- Durable - Completed operations are persisted, even if the machine restarts, etc.

*BASE*
- Basic Availability
- Soft State
- Eventual Consistency
- With BASE, instead of requiring consistency in each transaction, it is ok to return different values until the update is eventually applied. The system will prioritize Availability over Consistency.

![alt text](images/CAP.png "Title")

- Where is it ok to have Eventual Consistency? : Let’s say you are storing blog posts. it's okay to show old post until updated.

- Where would you want Consistency? Let’s say you are storing user passwords. Old password should not work anywhere. 

**SHRADING PARTITION FUNCTION**

![alt text](images/sharding-partition-function.png "Title")

**DYNAMIC SHRADDING**

![alt text](images/sharding-dynamic.png "Title")

**SHARADING CONSISTENET HASHING**

- With Consistent Hashing, you can minimize the movement of data when adding a new node in a distributed database.

![alt text](images/shrading-consistent-hashing.png "Title")

----------------------------------------------------------------
----------------------------------------------------------------

**INDEXING**

![alt text](images/db_indexing.png "Title")

**NOSQL DB**

- start of with no-sql db if you want scalable website
- traditional SQL is relational (structured), good for data anlysis 
- it's hard to scale horizontally
- when your data is growing, using sharding to 100 of db's will be difficult
- Nosql db can scale horizontally 
- key-value store is NoSQL

*TYPES*: 

- key-value store  (S3 or Redis key- string , value - list, json, blob(object))
- wide column store  (hbas, casandra , bigtable)

below two are abstartion on above two
- document store (mongo db)
- graph store (wide column store)


![alt text](images/nosql_1.png "Title")

**KEY VALUE STORE**

- 1000 comodity of machine, it will do fault tolerence, replication anad ssclability
- DynamoDB 

![alt text](images/key_value.png "Title")

*Type*

- kay-value store (metadata) **(DynamoDB)**
- object store (large objects like images, files, videos and stuff) **(S3)**
- In memeory DB - everything remains in RAM (so commodity of machines which we use for RAM, both write and read happens,  we also store info in hd if required) **(redis)**
- memchache - (similar to In memory DB, you only use it for cache where im memory DB you store the data)


![alt text](images/key_value_types.png "Title")


**WIDE COLUMN STORE**

- User profiles, photos, tweets you store it to wide column
- It adds some structure to key-value store
- It allows you to store some structured data in key-values store

![alt text](images/wide_column.png "Title")
![alt text](images/wide_column_1.png "Title")

*Data Model*

![alt text](images/key_value_types.png "Title")

- in the above model data is partitioned based on id
- we have three things - key, and in value - column family and column id
- column id is optional
- if you are not comfortable with this just use normal key value store DynamoDB

![alt text](images/wide_column_3.png "Title")


*Hbase and Bigtable Example* 

![alt text](images/wide_column_4.png "Title")

- Google trying to index the page
- they will be using the domain name as row-id, they will reverse it com.google
- column-family: content (html), anchor (list of wbisite links) 
- this also provides versioning of the data,  so in this example every crawling will have the new version
- how do you access [com.google][content][T2] (id,column-family, version)
- you can aslo specify max number of versions in Hbase

*another example of wide column*

![alt text](images/wide_column_5.png "Title")
![alt text](images/wide_column_6.png "Title")

- every time user adds new profile pic the older profile pic will be versioned with Hbase version
- if you want to look, users by city. You need to create index by city and store the values you need
- you are using more space, and your writes will take longer

-----
-----

**TRANSACTION PROCESSING**

![alt text](images/transaction_processing_1.png "Title")

*TWO-Phase commit* (very good if you bring this up in interview)

![alt text](images/transaction_processing_two_phase_commit.png.png "Title")

- Phase-1 updates values to multiple DB and if something fails pashe -2 will revert the update
- If all phase-1 is passe than commited
- it's a blocking protocol
- It also has to be consistent in replicated database

*Which databse to use for transcation processing*

![alt text](images/transaction_processing_3.png "Title")
![alt text](images/transaction_processing_4.png "Title")

- Requirements to remember, ACID and rollback
- MySql or SQL Server
- NoSQL are not consistent, you can use Hbase and Bigtable but theyu have high latency

*Facebook haystack read*
https://www.filepicker.io/api/file/cLvxxo6LRrWE1FQkjRqV


**DISTRIBUTED FILE SYSTEM**

![alt text](images/DFS_1.png "Title")
![alt text](images/DFS_2.png "Title")
![alt text](images/DFS_3.png "Title")
![alt text](images/DFS_4.png "Title")


**DISTRIBUTED DATA PROCESSING**

![alt text](images/distributed_data_processing_1.png "Title")
![alt text](images/distributed_data_processing_2.png "Title")
![alt text](images/distributed_data_processing_3.png "Title")
![alt text](images/distributed_data_processing_4.png "Title")


**NEAREST NEIGHBOUR SEARCH**

![alt text](images/spacial_index_1.png "Title")
![alt text](images/spacial_index_2.png "Title")
![alt text](images/spacial_index_3.png "Title")


**EXTRA**

![alt text](images/download_1.png "Title")
![alt text](images/download_2.png "Title")
![alt text](images/download_3.png "Title")
![alt text](images/download_4.png "Title")
![alt text](images/download_5.png "Title")
![alt text](images/download_6.png "Title")