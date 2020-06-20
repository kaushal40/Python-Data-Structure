

var obj = {
    "GMT-1200" : "Eniwetok or Kwaialein",
    "GMT-1100" : "Midway Island",
    "GMT-1000" : "Hawaii",
    "GMT-0900" : "Alaska",
    "GMT-0950" : "French Polynesia",
    "GMT-0800" : "San Francisco or British Columbia",
    "GMT-0700" : "Phoenix or British Columbia",
    "GMT-0600" : "Dallas",
    "GMT-0500" : "New York or Ontario",
    "GMT-0400" : "Caracas",
    "GMT-0300" : "Buenos Aires",
    "GMT-0200" : "Mid-Atlantic",
    "GMT-0100" : "Cape Verde",
    "GMT-0000" : "London or Ireland or Portugal",
    "GMT+0100" : "European Union",
    "GMT+0200" : "Russian Zone 1 and Eastern Europe",
    "GMT+0300" : "Russian Zone 2 and Baghdad",
    "GMT+0400" : "Abu Dhabi",
    "GMT+0450" : "Iran or Afganistan",
    "GMT+0550" : "India",
    "GMT+0500" : "India",
    "GMT+0600" : "Colombo and Shrilanka",
    "GMT+0700" : "Bangkok or Jakarta",
    "GMT+0800" : "China",
    "GMT+0900" : "Japan",
    "GMT+1000" : "Australia",
    "GMT+1100" : "Solomon",
    "GMT+1200" : "New Zealand"
};

function findIP(onNewIP) {
    var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
    var pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]}),
      noop = function() {},
      localIPs = {},
      ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
      key;
  
    function ipIterate(ip) {
      if (!localIPs[ip]) onNewIP(ip);
      localIPs[ip] = true;
    }
    pc.createDataChannel("");
    
    pc.createOffer(function(sdp) {
      sdp.sdp.split('\n').forEach(function(line) {
        if (line.indexOf('candidate') < 0) return;
        line.match(ipRegex).forEach(ipIterate);
      });
      pc.setLocalDescription(sdp, noop, noop);
    }, noop);
    
    pc.onicecandidate = function(ice) {
      if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
      ice.candidate.candidate.match(ipRegex).forEach(ipIterate);
    };
  }
  
  var ip = {} 
  function addIP(ip) {
    console.log('got ip: ', ip);
    if (ip != "0.0.0.0" && ip != "127.0.0.1"){
      document.getElementById('list-blue').innerHTML = "YOUR IP FOUND IS: " + ip;
    }
  }
  findIP(addIP);
  
  $.getJSON('https://api.ipdata.co?api-key=6fe379f8758f398067709ad39b647f2590a88e508e198a6a20ef87ce', function(data) {
    console.log(data)
    console.log("GMT"+data.time_zone.offset)
    d = new Date();
    start_index =  d.toString().search("GMT");
    end_index = start_index + 8; 
    console.log(d.toString().substring(start_index, end_index))
    console.log(JSON.stringify(data, null, 2));
  
    if ("GMT"+data.time_zone.offset === d.toString().substring(start_index, end_index)){
      document.getElementById('list-green').innerHTML = "WE LIKE USERS LIKE YOU, NOT USING VPN - HUGS AND KISSES FROM KAUSHAL"; 
    } else {
      document.getElementById('list-red').innerHTML = "STOP USING VPN, DON'T TRY TO FOOL ME OR ELSE I'LL KICK YOU, I KNOW YOU ARE NOT COMING FROM " + data.country_name + " ,my best guess is " + data[d.toString().substring(start_index, end_index)];  
    }
  });



  var obj = {
    "GMT-1200" : "Eniwetok or Kwaialein",
    "GMT-1100" : "Midway Island",
    "GMT-1000" : "Hawaii",
    "GMT-0900" : "Alaska",
    "GMT-0930" : "French Polynesia",
    "GMT-0800" : "US or Canada Pacific",
    "GMT-0700" : "US/Canada Mountaine",
    "GMT-0600" : "Dallas, Saskatchewan, Guadalajara (US/CANADA Central)",
    "GMT-0500" : "New York or Ontario",
    "GMT-0400" : "New York or Ontario",
    "GMT-0300" : "Brasilia, Georgetown or Greenland",
    "GMT-0200" : "Mid-Atlantic",
    "GMT-0100" : "Cape Verde",
    "GMT-0000" : "London or Dublin or Portugal",
    "GMT+0100" : "European Union",
    "GMT+0200" : "Russian Zone 1 and Eastern Europe",
    "GMT+0300" : "Russian Zone 2 and Baghdad",
    "GMT+0400" : "Abu Dhabi",
    "GMT+0430" : "Iran or Afganistan",
    "GMT+0530" : "India",
    "GMT+0500" : "India",
    "GMT+0600" : "Colombo and Shrilanka",
    "GMT+0700" : "Bangkok or Jakarta",
    "GMT+0800" : "China, Singapore or W. Australia",
    "GMT+0900" : "Japan or Korea",
    "GMT+1000" : "Australia",
    "GMT+1100" : "Solomon",
    "GMT+1200" : "New Zealand"
};

function findIP(onNewIP) {
    var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
    var pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]}),
      noop = function() {},
      localIPs = {},
      ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
      key;
  
    function ipIterate(ip) {
      if (!localIPs[ip]) onNewIP(ip);
      localIPs[ip] = true;
    }
    pc.createDataChannel("");
    
    pc.createOffer(function(sdp) {
      sdp.sdp.split('\n').forEach(function(line) {
        if (line.indexOf('candidate') < 0) return;
        line.match(ipRegex).forEach(ipIterate);
      });
      pc.setLocalDescription(sdp, noop, noop);
    }, noop);
    
    pc.onicecandidate = function(ice) {
      if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
      ice.candidate.candidate.match(ipRegex).forEach(ipIterate);
    };
  }
  
  var ip = {} 
  function addIP(ip) {
    console.log('got ip: ', ip);
    if (ip != "0.0.0.0" && ip != "127.0.0.1"){
      document.getElementById('list-blue').innerHTML = "YOUR IP FOUND IS: " + ip;
    }
  }
  findIP(addIP);
  
  $.getJSON('https://api.ipdata.co?api-key=6fe379f8758f398067709ad39b647f2590a88e508e198a6a20ef87ce', function(data) {
    console.log(data)
    console.log("GMT"+data.time_zone.offset)
    d = new Date();
    start_index =  d.toString().search("GMT");
    end_index = start_index + 8; 
    console.log(d.toString().substring(start_index, end_index))
    console.log(JSON.stringify(data, null, 2));
  
    if ("GMT"+data.time_zone.offset === d.toString().substring(start_index, end_index)){
      document.getElementById('list-green').innerHTML = "WE LIKE USERS LIKE YOU, NOT USING VPN - HUGS AND KISSES FROM KAUSHAL"; 
    } else {
      document.getElementById('list-red').innerHTML = "STOP USING VPN, DON'T TRY TO FOOL ME OR ELSE I'LL KICK YOU, I KNOW YOU ARE NOT COMING FROM " + data.country_name + " ,my best guess is " + obj[d.toString().substring(start_index, end_index)];  
    }
  });