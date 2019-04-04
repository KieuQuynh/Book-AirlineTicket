/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function (e) {
    var date;
//    document.getElementById("departure").addEventListener("change", function (e) {
//        date = document.getElementById("departure").value;
//        document.getElementById("return").setAttribute("min", date);
//    });
    var radio1 = document.getElementById("onetrip");
    if(radio1.checked) {
          document.getElementById("return").disabled = true;
       
    }
    radio1.addEventListener("change", function (e) {
        if (radio1.checked) {
            
            document.getElementById("return").disabled = true;
            document.getElementById("return").value = "";
        }
       
    });
    
    var radio2 = document.getElementById("roundtrip");
    radio2.addEventListener("change", function (e) {
        if (radio2.checked) {
            document.getElementById("return").disabled = false;
            document.getElementById("return").innerHTML = "";
        }
    });



};
