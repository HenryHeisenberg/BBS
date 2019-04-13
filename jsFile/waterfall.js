let myarr = new Array();

// 随机生成若干个div
function cDiv() {
  let num = document.getElementById("input").value;

  for (let i = 0; i < num; i++) {
    let rand = Math.random() * 90 + 100;
    let ran = Math.round(rand);
    document.getElementById(
      "fDiv"
    ).innerHTML += `<div id='div${i}' class='sDiv' style='height:${ran}px;' >${i}</div>`;
    
  }
    myarr = document.getElementsByClassName("sDiv");
}
let arr = new Array(); //保存高度
function waterfall() {
  // 获取当前窗口大小
  let pageWidth = getClient().width;
  let igWidth = 270;
  let column = parseInt(pageWidth / igWidth);
  console.log("行" + column);

  for (let i = 0; i < myarr.length; i++) {
     if(i<column){
    //满足该条件则在第一行
    myarr[i].style.top = 0;
    myarr[i].style.left = igWidth * i + "px";
    arr.push(myarr[i].offsetHeight)//获取到了第一行所有盒子的高度
    
   
  }
    else{
            
            minHeight = arr[0];
            index = 0;//最小高度的下标
            for(j=0;j<arr.length;j++){
                //找出其中最小高度的盒子
                if(minHeight>arr[j]){
                    minHeight=arr[j];
                    index=j;
                }
            }
            myarr[i].style.top = arr[index] + 20 +'px';
            myarr[i].style.left = myarr[index].offsetLeft  +'px';

            //重置所有列的高度
            arr[index] = arr[index] + 20 + myarr[i].offsetHeight;
        }
  }
}

// 获取屏幕尺寸
function getClient() {
  return {
    width:
      window.innerWidth ||
      document.documentElement.clientWidth ||
      document.body.width,
    height:
      window.innerHeight ||
      document.documentElement.clientWidth ||
      document.body.height
  };
}

//尺寸改变就变化
window.onresize = function(){
    waterfall();
}