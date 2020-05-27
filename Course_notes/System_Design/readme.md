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



