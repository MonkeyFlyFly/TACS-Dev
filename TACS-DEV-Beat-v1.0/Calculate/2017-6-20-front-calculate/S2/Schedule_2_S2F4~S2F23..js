function schedule_2_S2F4(){
	calc_Schedule_2_S2F4();
}
function calc_Schedule_2_S2F4(){
var ele_Fiscal_Year=bptEle("S2F1","S2F3");
var sum_Fiscal_Year=sub_total(ele_Fiscal_Year);
var s2f4=bptEle("S2F4");
$(s2f4[0]).val(sum_Fiscal_Year);
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