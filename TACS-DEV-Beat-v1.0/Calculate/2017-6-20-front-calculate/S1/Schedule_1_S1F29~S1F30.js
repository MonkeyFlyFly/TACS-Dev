function schedule_1_S1F29_S1F30(){
	calc_Schedule_1_S1F29_S1F30();
}
function calc_Schedule_1_S1F29_S1F30(){
var ele_Fiscal_Year=bptEle("S1F9","S1F11","S1F13","S1F15","S1F17","S1F19","S1F21","S1F23","S1F25","S1F27");
var ele_Previous_Fiscal_Year=bptEle("S1F10","S1F12","S1F14","S1F16","S1F18","S1F20","S1F22","S1F24","S1F26","S1F28");
var sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
var sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f29=bptEle("S1F29");
var s1f30=bptEle("S1F30");
$(s1f29[0]).val(sum_Fiscal_Year);
$(s1f30[0]).val(sum_Previous_Fiscal_Year);
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