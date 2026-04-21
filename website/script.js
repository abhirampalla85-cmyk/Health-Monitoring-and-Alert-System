function login(){

let username = document.getElementById("username").value;
let email = document.getElementById("email").value;
let password = document.getElementById("password").value;

fetch("http://localhost:8080/api/auth/login", {
method: "POST",
headers: {"Content-Type":"application/json"},
body: JSON.stringify({username,email,password})
})
.then(res=>res.text())
.then(data=>{
if(data.trim()=="Success"){
localStorage.setItem("username", username);
window.location.href="dashboard.html";
}else{
alert("Invalid login");
}
});
}


function analyzeHealth(){

let temp = document.getElementById("temp").value;
let heart = document.getElementById("heart").value;
let sleep = document.getElementById("sleep").value;
let fatigue = document.getElementById("fatigue").value;

let status = "Normal";

if(temp > 100 || heart > 110 || fatigue > 7){
status = "Critical";
}
else if(temp > 99 || heart > 100 || fatigue > 5){
status = "Warning";
}

fetch("http://localhost:8080/api/health/save", {
method: "POST",
headers: {"Content-Type":"application/json"},
body: JSON.stringify({
userId:1,
temperature:temp,
heartRate:heart,
sleepHours:sleep,
fatigueLevel:fatigue,
status:status
})
})
.then(res=>res.text())
.then(()=>{
window.location.href="result.html?status="+status;
});
}