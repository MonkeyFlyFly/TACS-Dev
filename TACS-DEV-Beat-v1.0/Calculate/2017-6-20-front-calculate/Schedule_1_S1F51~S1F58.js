function current_liabilities(){
	calc_Current_liabilities();
}
function calc_Current_liabilities(){
var ele_Fiscal_Year=bptEle("S1F41","S1F43","S1F73","S1F45","S1F47","S1F49");
var ele_Previous_Fiscal_Year=bptEle("S1F42","S1F44","S1F74","S1F46","S1F48","S1F50");
var sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
var sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f51=bptEle("S1F51");
var s1f52=bptEle("S1F52");
$(s1f51[0]).val(sum_Fiscal_Year);
$(s1f52[0]).val(sum_Previous_Fiscal_Year);

ele_Fiscal_Year=bptEle("S1F39","S1F51");
ele_Previous_Fiscal_Year=bptEle("S1F40","S1F52");
sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
var s1f53=bptEle("S1F53");
var s1f54=bptEle("S1F54");
$(s1f53[0]).val(sum_Fiscal_Year);
$(s1f54[0]).val(sum_Previous_Fiscal_Year);

ele_Fiscal_Year=bptEle("S1F29","S1F51");
ele_Previous_Fiscal_Year=bptEle("S1F30","S1F52");
sum_Fiscal_Year=sub_total(ele_Fiscal_Year);
sum_Previous_Fiscal_Year=sub_total(ele_Previous_Fiscal_Year);
var s1f55=bptEle("S1F55");
var s1f56=bptEle("S1F56");
$(s1f55[0]).val(sum_Fiscal_Year);
$(s1f56[0]).val(sum_Previous_Fiscal_Year);

ele_Fiscal_Year=bptEle("S1F29","S1F51");
ele_Previous_Fiscal_Year=bptEle("S1F30","S1F52");
if($(s1f55[0]).val()>0){
	sum_Fiscal_Year=sum_total(ele_Fiscal_Year);
	sum_Previous_Fiscal_Year=sum_total(ele_Previous_Fiscal_Year);
}else{
	sum_Fiscal_Year=sub_total(ele_Fiscal_Year);
	sum_Previous_Fiscal_Year=sub_total(ele_Previous_Fiscal_Year);
}
var s1f57=bptEle("S1F57");
var s1f58=bptEle("S1F58");
$(s1f57[0]).val(sum_Fiscal_Year);
$(s1f58[0]).val(sum_Previous_Fiscal_Year);
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

var sub_total=function calTotal(arr){
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
			sum_toal=temp;
			sum_toal-=temp;
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