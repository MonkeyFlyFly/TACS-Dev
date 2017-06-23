function schedule_1_S1F39_S1F40(){
	calc_Schedule_1_S1F39_S1F40();
}
function calc_Schedule_1_S1F39_S1F40(){
var ele_Fiscal_Year=bptEle("S1F33","S1F35","S1F37");
var ele_Previous_Fiscal_Year=bptEle("S1F34","S1F36","S1F38");
var sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
var sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f39=bptEle("S1F39");
var s1f40=bptEle("S1F40");
$(s1f39[0]).val(sum_Fiscal_Year);
$(s1f40[0]).val(sum_Previous_Fiscal_Year);
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