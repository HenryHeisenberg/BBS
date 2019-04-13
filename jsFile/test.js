var buttons = document.getElementsByClassName("div");
var arr = new Array();

for (let index = 0; index < buttons.length; index++) {
   // 
   if(true){
    buttons[index].style.width = index+'px';
    buttons[index].style.height = index+'px';
    arr[index] = index;
   }
   /*buttons[index].onclick=function () {
       alert(index);
     }*/
}