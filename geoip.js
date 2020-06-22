var obj = {
  "GMT-1200" : "Eniwetok or Kwaialein",
  "GMT-1100" : "Midway Island",
  "GMT-1000" : "Hawaii",
  "GMT-0900" : "Alaska",
  "GMT-0930" : "French Polynesia",
  "GMT-0800" : "US or Canada Pacific",
  "GMT-0700" : "Vancouver, Phoenix or LA",
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

function findIP(onNewIP, actaulip) {
  var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
  var pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]}),
  noop = function() {},
  localIPs = {},
  ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
  key;

  function ipIterate(ip) {
  if (!localIPs[ip]) onNewIP(ip, actaulip);
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
function addIP(ip, actaulip) {
  if (ip != "0.0.0.0" && ip != "127.0.0.1" && ip != actaulip){
  document.getElementById('list-blue1').innerHTML = "YOUR IP FOUND IS: " + ip;
  $.getJSON('https://api.ipdata.co/'+ip+'?api-key=6fe379f8758f398067709ad39b647f2590a88e508e198a6a20ef87ce', function(data) {
      document.getElementById('list-red2').innerHTML = "OUR GUESS IS: " + data.country_name + " CITY: " + data.city;
});
  }
}

$.getJSON('https://api.ipdata.co?api-key=6fe379f8758f398067709ad39b647f2590a88e508e198a6a20ef87ce', function(data) {
  d = new Date();
  start_index =  d.toString().search("GMT");
  end_index = start_index + 8; 

  if ("GMT"+data.time_zone.offset === d.toString().substring(start_index, end_index)){
  var img = document.createElement('img'); 
  img.src =  'https://vectorified.com/images/icon-pass-16.png'; 
  img.width = 150;
  img.height = 150;
  document.getElementById('img1').appendChild(img); 
  document.getElementById('list-green').innerHTML = "VPN NOT DETECTED (SCORE:*)"; 
  document.getElementById('list-green1').innerHTML = "REQUEST COUNTRY: " + data.country_name;
  } else {
  var img = document.createElement('img'); 
  img.src =  'https://images.vexels.com/media/users/3/193115/isolated/preview/2a245dedacc60a1187cc1413022d5695-covid-stop-sign-badge-by-vexels.png';
  img.width = 150;
  img.height = 150;
  document.getElementById('img1').appendChild(img); 
  document.getElementById('list-red').innerHTML = "VPN DETECTED (SCORE:*)"
  document.getElementById('list-red1').innerHTML = "REQUEST COUNTRY: " + data.country_name;
  document.getElementById('list-red2').innerHTML = "OUR BEST GUESS IS " + obj[d.toString().substring(start_index, end_index)];
  findIP(addIP, data.ip);
  }
});