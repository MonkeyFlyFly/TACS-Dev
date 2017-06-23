function schedule_1_S1F7_S1F8(){
	calc_schedule_1_S1F7_S1F8();
}
function calc_schedule_1_S1F7_S1F8(){
var ele_Fiscal_Year=bptEle("S1F1","S1F3","S1F5","S1F69","S1F71");
var ele_Previous_Fiscal_Year=bptEle("S1F2","S1F4","S1F6","S1F70","S1F72");
var sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
var sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f7=bptEle("S1F7");
var s1f8=bptEle("S1F8");
$(s1f7[0]).val(sum_Fiscal_Year);
$(s1f8[0]).val(sum_Previous_Fiscal_Year);
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