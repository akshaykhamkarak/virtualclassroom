
var db = firebase.firestore();

function storedata(){
    var u=document.getElementById("name").value;
	var v = document.getElementById("add").value;
	var w = document.getElementById("email").value;
	var x = document.getElementById("pincode").value;
	var y = document.getElementById("mobile").value;
	var z = document.getElementById("meterno").value;
db.collection("new_reg").doc(y).set({
    CustName: u,
    Address: v,
    Email: w,
    Pincode:x,
    PhoneNo:y,
   // 
})
db.collection("new_reg").doc(y).collection("meter").doc().set({
    CustName: u,
    MeterID:z
    
})
.then(function() {
    console.log("Document successfully written!");
     
    
})
.catch(function(error) {
    console.error("Error writing document: ", error);
});
}


