function Schedule_1_S1F67_S1F68(){
	calc_Schedule_1_S1F67_S1F68();
}
function calc_Schedule_1_S1F67_S1F68(){
var ele_Fiscal_Year=bptEle("S1F59","S1F75","S1F61","S1F63","S1F65");
var ele_Previous_Fiscal_Year=bptEle("S1F60","S1F76","S1F62","S1F64","S1F66");
var sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
var sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f67=bptEle("S1F67");
var s1f68=bptEle("S1F68");
$(s1f67[0]).val(sum_Fiscal_Year);
$(s1f68[0]).val(sum_Previous_Fiscal_Year);
}









var sum_total=function calTotal(arr){
	var arr_length=arr.length;
	var sum_toal=0;
	var temp="";
	for(var i=0; i< arr_length; i++){
		temp=$(arr[i]).val()==""?"0":$(arr[i]).val();
		if(temp!=undefined){
			temp=temp.replace(/,/g,"");
		}
		temp=parseFloat(temp);
		if(typeof(temp)=='number' && !isNaN(temp)){
			sum_toal+=temp;
		}	
	}
	return sum_toal;
}



var bptEle=function combineBPTElement(/* ... */){
	var arr_length=arguments.length;
	var pre="#Cret00BPTCTRBN";	
	var suffix="";
	var arr=[];
	for(var i=0; i<arr_length;i++){
		suffix=arguments[i].trim();
		arr.push(pre+suffix);
	}
	return arr;
}
//var arr=["#Cret00BPTCTRBNS1F1","#Cret00BPTCTRBNS1F2","#Cret00BPTCTRBNS2F1","#Cret00BPTCTRBNS2F2"];
//sum_total(arr);