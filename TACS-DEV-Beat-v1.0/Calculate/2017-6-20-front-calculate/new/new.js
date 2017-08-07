$(function(){
	disableCalculatedInput();
	previousS5F3 = 0;
	previousS7F3 = 0;
	previousS3F3 = 0;
	carriedForwardLoss_S5F37 = 0;
	carriedForwardLoss_S7F37 = 0;
	carriedForwardLoss_S3F37 = 0;
	codeBus="";
	taxpayerType="";
	var versionUid = $("#Cret00BPTRetVerUid").val();
		$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS5F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS5F3 = data.val;
		 }
	});
		$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS7F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS7F3 = data.val;
		 }
	});
		$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS3F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS3F3 = data.val;
		 }
	});
		$.ajax({
		 type:'post',
		 url:'getBPTloss.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS5F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 carriedForwardLoss_S5F37 = data.val;
		 }
	});
	//S7F37
		 $.ajax({
		 type:'post',
		 url:'getBPTloss.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS7F37"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 carriedForwardLoss_S7F37 = data.val;
		 }
	});
		 $.ajax({
		 type:'post',
		 url:'getBPTloss.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS3F37"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 carriedForwardLoss_S3F37 = data.val;
		 }
	});
		 $.ajax({
		 type:'post',
		 url:'getBPTloss.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS3F37"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 codeBus = data.val;
		 }
	});
		 $.ajax({
		 type:'post',
		 url:'getBPTloss.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRBNS3F37"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 taxpayerType = data.val;
		 }
	});	
});
var calculateBN = (function(){
	var options = {};
	options.prefix = "Cret00BPTCTRBN";
	function getMaxValue(val1,val2){
		if(val1>val2){
			return val1;
		}else{
			return val2;
		}
	}
	function getMinValue(val1,val2){
		if(val1>val2){
			return val2;
		}else{
			return val1;
		}
	}	
	function getValue(code){
		if(""==$("#"+options.prefix+code+"hidden").val()){
			return parseFloat(0);
		}else{
			return parseFloat($("#"+options.prefix+code+"hidden").val());
		}
	}
	
	function setBNValue(id,val){
		val = parseFloat(val).toFixed(2);
		$("#"+options.prefix+id).val(val);
		$("input[name='"+options.prefix+id+"']").val(val);
	}
	function schedule1(){
		  setBNValue("S1F7",getValue("S1F1")+getValue("S1F3")+getValue("S1F5")+getValue("S1F69")+getValue("S1F71"));
		  setBNValue("S1F8",getValue("S1F2")+getValue("S1F4")+getValue("S1F6")+getValue("S1F70")+getValue("S1F72"));
		  setBNValue("S1F29",getValue("S1F9")+getValue("S1F11")+getValue("S1F13")+getValue("S1F15")+getValue("S1F17")+getValue("S1F19")+getValue("S1F21")+getValue("S1F23")+getValue("S1F25")+getValue("S1F27"));
		  setBNValue("S1F30",getValue("S1F10")+getValue("S1F12")+getValue("S1F14")+getValue("S1F16")+getValue("S1F18")+getValue("S1F20")+getValue("S1F22")+getValue("S1F24")+getValue("S1F26")+getValue("S1F28"));
		  setBNValue("S1F31",getValue("S1F7")+getValue("S1F29"));
		  setBNValue("S1F32",getValue("S1F8")+getValue("S1F30"));
		  setBNValue("S1F39",getValue("S1F33")+getValue("S1F35")+getValue("S1F37"));
		  setBNValue("S1F40",getValue("S1F34")+getValue("S1F36")+getValue("S1F38"));
		  setBNValue("S1F51",getValue("S1F41")+getValue("S1F43")+getValue("S1F73")+getValue("S1F45")+getValue("S1F47")+getValue("S1F49"));
		  setBNValue("S1F52",getValue("S1F42")+getValue("S1F44")+getValue("S1F74")+getValue("S1F46")+getValue("S1F48")+getValue("S1F50"));
		  setBNValue("S1F53",getValue("S1F39")+getValue("S1F51"));
		  setBNValue("S1F54",getValue("S1F40")+getValue("S1F52"));
		  setBNValue("S1F55",getValue("S1F29")-getValue("S1F51"));
		  setBNValue("S1F56",getValue("S1F30")-getValue("S1F52"));		  
		  setBNValue("S1F57",getValue("S1F7")+getValue("S1F55"));
		  setBNValue("S1F58",getValue("S1F8")+getValue("S1F56"));
		  setBNValue("S1F67",getValue("S1F59")+getValue("S1F75")+getValue("S1F61")+getValue("S1F63")+getValue("S1F65"));
		  setBNValue("S1F68",getValue("S1F60")+getValue("S1F76")+getValue("S1F62")+getValue("S1F64")+getValue("S1F66"));
		  
	}
	function schedule2(){
		setBNValue("S2F4",getValue("S2F1")-getValue("S2F3"));
		setBNValue("S2F9",getValue("S2F5")+getValue("S2F6")+getValue("S2F8"));
		setBNValue("S2F11",getValue("S2F9")-getValue("S2F10"));
		setBNValue("S2F12",getValue("S2F4")-getValue("S2F11"));
		setBNValue("S2F13",getValue("S2F12")/getValue("S2F11"));
		setBNValue("S2F23",(getValue("S2F12")+getValue("S2F14")+getValue("S2F15")+getValue("S2F17"))-(getValue("S2F18")+getValue("S2F19")+getValue("S2F20")+getValue("S2F21")+getValue("S2F22")));
	}
	function schedule3(){
		setBNValue("S3F1",getValue("S2F3"));
		setBNValue("S3F18",getValue("S3F2")+getValue("S3F3")+getValue("S3F4")+getValue("S3F40")+getValue("S3F5")+getValue("S3F6")+getValue("S3F7")+getValue("S3F8")+getValue("S3F9")+getValue("S3F10")+getValue("S3F11")+getValue("S3F12")+getValue("S3F13")+getValue("S3F14")+getValue("S3F15")+getValue("S3F16")+getValue("S3F38")+getValue("S3F38A"));
		setBNValue("S3F19",getValue("S3F1")+getValue("S3F18"));
		setBNValue("S3F20",getValue("S8F16"));
		setBNValue("S3F21",getMinValue(getValue("s3f21"),getValue("S3F12")));
		var smallV = 0;
		var s2f23 = getValue("S2F23");
		if(s2f23 < 0) {
			smallV = 0;
		}else {
		var s3f4 = getValue("S3F4");
		var m10_S2f23 = s2f23 * 0.1;
		if(s3f4 > m10_S2f23) {
		  smallV = m10_S2f23;
		}else {
		  smallV = s3f4;
		}
		}
		var m25_S3f3 = getValue("S3F3") * 0.25;
		var pvS3f3 = previousS3F3;
		var p_m25_S3f3 = pvS3f3 * 0.25;
		setBNValue("S3F25",getValue("S3F2")+smallV+m25_S3f3+p_m25_S3f3);
		setBNValue("S3F26",getMinValue(getValue("3F26"),getValue("S2F15")));
		setBNValue("S3F28",getValue("S3F20")+getValue("S3F21")+getValue("S3F22")+getValue("S3F25")+getValue("S3F26")+getValue("S3F39"));
		var s3f19 = getValue("S3F19");
		var s3f37 = getValue("S3F19") - getValue("S3F28");  
		if(s3f19 > 0 && s3f37 <= 0) {
			var m25_s3f3 = getValue("S3F3") * 0.25;
			var m50_s3f28 = getValue("S3F28") * 0.5;
			if(m25_s3f3, m50_s3f28) {
			  s3f37 = 0;
			}
		}
		setBNValue("S3F37",s3f37);
		setBNValue("S3F27",carriedForwardLoss_S3F37);
		setBNValue("S3F29",getValue("3F37")-getValue("S3F27"));
		var s3f30 = 0;
		var s9f9 = getValue("S9F9");
		if(s9f9 > 0) {
			s3f30 = s9f9;
		}		
		setBNValue("S3F30",s3f30);
		setBNValue("S3F31",getValue("S2F14")-getValue("S2F19"));
		setBNValue("S3F36",getValue("S3F29")-(getValue("S3F30")+getValue("S3F31")+getValue("S3F32")+getValue("S3F33")+getValue("S3F34")+getValue("S3F35")));
	}
	function schedule4(){
		setBNValue("S4F4",getValue("S4F1")-getValue("S4F3"));
		setBNValue("S4F9",(getValue("S4F5")+getValue("S4F6")+getValue("S4F7"))-getValue("S4F8"));
		setBNValue("S4F15",getValue("S4F9")+getValue("S4F10")+getValue("S4F11")+getValue("S4F12")+getValue("S4F13")+getValue("S4F14"));
		setBNValue("S4F18",(getValue("S4F15")+getValue("S4F16"))-getValue("S4F17"));
		setBNValue("S4F22",(getValue("S4F18")+getValue("S4F19")+getValue("S4F20"))-getValue("S4F21"));
		setBNValue("S4F23",getValue("S4F4")-getValue("S4F22"));
		setBNValue("S4F24",(getValue("S4F23")*100)/getValue("S4F22"));
		setBNValue("S4F34",(getValue("S4F23")+getValue("S4F25")+getValue("S4F26")+getValue("S4F28"))-getValue("S4F29")-getValue("S4F30")-getValue("S4F31")-getValue("S4F32")-getValue("S4F33"));
	}
	function schedule5(){
		setBNValue("S5F1",getValue("S4F34"));
		setBNValue("S5F18",getValue("S5F2")+getValue("S5F3")+getValue("S5F4")+getValue("S5F38")+getValue("S5F5")+getValue("S5F6")+getValue("S5F7")+getValue("S5F8")+getValue("S5F9")+getValue("S5F10")+getValue("S5F11")+getValue("S5F12")+getValue("S5F13")+getValue("S5F14")+getValue("S5F15")+getValue("S5F16")+getValue("S5F38A"));
		setBNValue("S5F19",getValue("S5F1")+getValue("S5F18"));
		setBNValue("S5F20",getValue("S8F17"));
		setBNValue("S5F21",getMinValue(getValue("S5f21"),getValue("S5f12")));
		//------------------------------S5F25-------------start------------------------
		  var smallV = '';
		  var s4f34 = getValue("S4F34");
		  if(s4f34 < 0) {
			smallV = 0;
		  }else {
			var S5f4 = getValue("S5F4");
			var m10_S4f34 = getValue("S4F34")* 0.1;
			if(S5f4 > m10_S4f34) {
			  smallV = m10_S4f34;
			}else {
			  smallV = S5f4;
			}
		  }
		var m25_S5f3 = getValue("S5F3") * 0.25;	
		var pvS5f3 = previousS5F3;
		var p_m25_S5f3 = pvS5f3 * 0.25;		
		setBNValue("S5F25",getValue("S5F2")+smallV+m25_S5f3+p_m25_S5f3);
		//------------------------------S5F25--------end-----------------------------
		setBNValue("S5F26",getMinValue(getValue("S5f26"),getValue("S4F26")));
		setBNValue("S5F28",getValue("S5F20")+getValue("S5F21")+getValue("S5F22")+getValue("S5F25")+getValue("S5F26")+getValue("S5F39"));
		//-------------------------S5F37----START------------------------------------
		  var S5f19 = getValue("S5f19");
		  var S5f37 = getValue("S5F19")-getValue("S5F28"); 
		  if(S5f19 > 0 && S5f37 <= 0) {
			var m25_S5f3 = getValue("S5F3") * 0.25;
			var m50_S5f28 = getValue("S5F28") * 0.5;
			if(m25_S5f3 > m50_S5f28) {
			  S5f37 = 0;
			}
		  }
		setBNValue("S5F37",S5f37);
		//-----------------------------------END---------------------------------------
		//----------------------------S5F27 START------------------------------------------------
		setBNValue("S5F27",carriedForwardLoss_S5F37);
		//-----------------------------S5F27  END--------------------------------------------------
		setBNValue("S5F29",getValue("S5F37")-getValue("S5F27"));
		var S5f30 = 0;
		var s9f10 = getValue("S9F10");
		if(s9f10 > 0) {
			S5f30 = s9f10;
		}
		setBNValue("S5F30",S5f30);
		setBNValue("S5F31",getValue("S4F25")-getValue("S4F30"));
		setBNValue("S5F36",getValue("S5F29")-(getValue("S5F30")+getValue("S5F31")+getValue("S5F32")+getValue("S5F33")+getValue("S5F34")+getValue("S5F35")));
	}
	function schedule6(){
		setBNValue("S6F4",getValue("S6F2")+getValue("S6F3"));
		setBNValue("S6F5",getValue("S6F1")-getValue("S6F4"));
		setBNValue("S6F15",getValue("S6F5")+getValue("S6F6")+getValue("S6F7")+getValue("S6F9")-getValue("S6F10")-getValue("S6F11")-getValue("S6F12")-getValue("S6F13")-getValue("S6F14"));
	}
	function schedule7(){
		setBNValue("S7F1",getValue("S6F15"));
		setBNValue("S7F18",getValue("S7F2")+getValue("S7F3")+getValue("S7F4")+getValue("S7F38")+getValue("S7F5")+getValue("S7F6")+getValue("S7F7")+getValue("S7F8")+getValue("S7F9")+getValue("S7F10")+getValue("S7F11")+getValue("S7F12")+getValue("S7F13")+getValue("S7F14")+getValue("S7F15")+getValue("S7F16")+getValue("S7F38A"));
		setBNValue("S7F19",getValue("S7F1")+getValue("S7F18"));
		setBNValue("S7F20",getValue("S7F18"));
		setBNValue("S7F21",getMinValue(getValue("S7F21"),getValue("S7F12")));
		var smallV = 0;
		var s6f15 = getValue("6F15");
		if(s6f15 < 0) {
			smallV = 0;
		}else {
			var S7f4 = getValue("S7F4");
			var m10_s6f15 = s6f15* 0.1;
			if(S7f4 > m10_s6f15)) {
			  smallV = m10_s6f15;
			}else {
			  smallV = S7f4;
			}
		}
		var m25_S7f3 =getValue("S7F3") * 0.25;
		var pvS7f3 = previousS7F3;
		var p_m25_S7f3 = pvS7f3 * 0.25;
		setBNValue("S7F25",getValue("S7F2")+smallV+m25_S7f3+p_m25_S7f3);
		setBNValue("S7F26",getMinValue(getValue("S7f26"),getValue("S6F7")));
		setBNValue("S7F28",getValue("S7F20")+getValue("S7F21")+getValue("S7F22")+getValue("S7F25")+getValue("S7F26")+getValue("S7F39"));
		var S7f19 = getValue("S7F19");
		var S7f37 = getValue("S7F19") - getValue("S7F28");  
		if(S7f19 > 0 && S7f37 <= 0) {
			var m25_S7f3 = getValue("S7F3") * 0.25;
			var m50_S7f28 = getValue("S7F28") * 0.5;
			if(m25_S7f3 > m50_S7f28) {
			  S7f37 = 0;
			}
		}
		setBNValue("S7F37",S7f37);
		setBNValue("S7F27",carriedForwardLoss_S7F37);
		setBNValue("S7F29",getValue("S7F37")-getValue("S7F27"));
		var S7f30 = 0;
		var s9f11 = getValue("S9F11");
		if(s9f11 > 0) {
			S7f30 = s9f11;
		}
		setBNValue("S7F30",S7f30);
		setBNValue("S7F31",getValue("S6F6")-getValue("S6F11"));
		setBNValue("S7F36",getValue("S7F29")-(getValue("S7F30")+getValue("S7F31")+getValue("S7F32")+getValue("S7F33")+getValue("S7F34")+getValue("S7F35")));		
	}
	function schedule8(){
		//no setBNValue("S8F3",);
		setBNValue("S8F6",getValue("S8F3")+getValue("S8F4")-getValue("S8F5"));
		//no setBNValue("S8F7",);
		setBNValue("S8F9",(getValue("S8F3")*getValue("S8F8"))/100);
		setBNValue("S8F10",(getValue("S8F4")*getValue("S8F8"))/200);
		setBNValue("S8F11",(getValue("S8F5")*getValue("S8F8"))/200);
		setBNValue("S8F12",getValue("S8F9")+getValue("S8F10")-getValue("S8F11"));
		setBNValue("S8F13",getValue("S8F7")+getValue("S8F12"));
		setBNValue("S8F14",getValue("S8F6")-getValue("S8F13"));
		setBNValue("S8F15",getValue("S8F15")-getValue("S8F12"));
	}
	function schedule9(){
		  var s9f2 = getValue("S9F2");
		  //ajax Map subTypeMap = assResult.getSubTypeMap();
		  String s8f5 = null;
		  if(null!=s9f2 && subTypeMap != null) {
			//s8f5 = (String)subTypeMap.get(s9f2);
		  }
		  if(null!=s8f5) {
			s8f5 = 0;
		  }
		setBNValue("S9F5",s8f5);
		setBNValue("S9F7",getValue("S9F4")-((getValue("S9F5"))-(getValue("S9F6"))));
		setBNValue("S9F8",getValue("S9F8")+getValue("S9F7"));
	}
	function schedule10(){
		  var s10f1 = 0;
		  var s10f3 = 0;
		  var s10f5 = 0;
		  if("10_NAT_TRADE".equals(codeBus) || "2_NAT_TRADE".equals(codeBus)){
		  }else{
			if("partnership".equals(taxpayerType)){
			  s10f1 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36");
			}else{
			  s10f3 = getValue("S3F36")+ getValue("S7F36");
			  s10f5 = getValue("S5F36");
			}
		  }
		setBNValue("S10F1",s10f1);
		var myZero = 0;
		if(s10f1 > myZero){
		 setBNValue("S10F2",s10f1*0.15);
		}else{
		  setBNValue("S10F2",myZero);
		}
		setBNValue("S10F3",s10f3);
		//ajax String s10f4 = TaxValidation.calcTaxPable("BPT","comm",$Cret00BPTRetVerUid.needValue,s10f3,s10f5);
		if(s10f4 > myZero){
		 setBNValue("S10F4",s10f4);
		}else{
		 setBNValue("S10F4",myZero);
		}
		setBNValue("S10F5",s10f5);
		//ajax String s10f6 = TaxValidation.calcTaxPable("BPT","indu",$Cret00BPTRetVerUid.needValue,s10f3,s10f5);
		if(s10f6 > myZero)){
		 setBNValue("S10F6",s10f6);
		}else{
		 setBNValue("S10F6",myZero);
		}
	}
	function schedule10_part2(){
		//ajax String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"m");
		  var s10f9 = 0;
		  if("2_NAT_TRADE".equals(codeBus)){
			s10f9 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36");
		  }
		setBNValue("S10F9",s10f9);
		  if(getValue("S10F9") > 0){
			setBNValue("S10F10",getValue("S10F9") * 0.3);
		  }else{
		  setBNValue("S10F10",0);
		  }
	}
	function schedule10_part3(){
		  //ajax String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"s");
		  var s10f11 = 0;
		  if(null!=codeBus&&codeBus.indexOf("119_NAT_ACTIVITY")!=-1){
			s10f11 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36"); 
		  }
		    if(getValue("S10F11") > 0){
			setBNValue("S10F12",getValue("S10F11") * 0.35);
		  }else{
			setBNValue("S10F12",0);
		  }
		  //ajax String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"s");
		  var s10f13 = String.valueOf(0);
		  if(null!=codeBus&&(codeBus.indexOf("54_NAT_ACTIVITY")!=-1||codeBus.indexOf("105_NAT_ACTIVITY")!=-1)){
			s10f13 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36");
		  }
		setBNValue("S10F13",s10f13);
		   if(getValue("S10F13") > 0){
		  setBNValue("S10F14",getValue("S10F13")*0.15);
		  }else{
		  setBNValue("S10F14",0);
		  }
		  //ajax String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"m");
		  var s10f15 = 0;
		  if("12_NAT_TRADE".equals(codeBus)){  
			s10f15 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36");
		  }
		  setBNValue("S10F15",s10f15);
		    if(getValue("S10F15") > 0){
		  setBNValue("S10F16",getValue("S10F15") * 0.15);
		  }else{
		  setBNValue("S10F16", 0);
		  }
		  var codeExempted = "NO";
		  var s10f19 = 0;
		  if("YES".equals(codeExempted)) {
			s10f19 = getValue("S3F36")+getValue("S5F36")+getValue("S7F36");
		  }
		setBNValue("S10F19",s10f19);
		  if(getValue("S10F19") > 0){
		  setBNValue("S10F20",getValue("S10F19")*0.05");
		  }else{
		  setBNValue("S10F20",0);
		  }
		setBNValue("S10F7",getValue("S3F31")+getValue("S5F31")+getValue("S7F31"));
		  if(getValue("S10F7") > 0){
		 setBNValue("S10F8",getValue("S10F7") * 0.1);
		  }else{
		  setBNValue("S10F8",0);
		  }
		setBNValue("S10F17",getValue("S9F8"));
		  if(getValue("S10F17")> 0){
		  setBNValue("S10F18",getValue("S10F17") * 0.15);
		  }else{
		   setBNValue("S10F18",0);
		  }
		setBNValue("S10F21",getValue("S3F32")+getValue("S5F32")+getValue("S7F32"));
		  if(getValue("S10F21") > 0){
		  setBNValue("S10F22",getValue("S10F21") * 0.02);
		  }else{
		  setBNValue("S10F22",0);
		  }
		setBNValue("S10F23",getValue("S3F33")+getValue("S5F33")+getValue("S7F33"));
		  if(getValue("S10F23") > 0){
		  setBNValue("S10F24",getValue("S10F23") * 0.02);
		  }else{
		  setBNValue("S10F24",0);
		  }
		setBNValue("S10F25",getValue("S3F34")+getValue("S5F34")+getValue("S7F34"));
		  if(getValue("S10F25") > 0){
		  setBNValue("S10F26",getValue("S10F25") * 0.02);
		  }else{
		  setBNValue("S10F26",0);
		  }
		setBNValue("S10F27",getValue("S3F35")+getValue("S5F35")+getValue("S7F35"));
		  if(getValue("S10F27")> 0){
		  setBNValue("S10F28",getValue("S10F27")*0.02);
		  }else{
		  setBNValue("S10F28",0);
		  }
		setBNValue("S10F29",getValue("S10F2")+getValue("S10F4")+getValue("S10F6")+getValue("S10F8")+getValue("S10F10")+getValue("S10F12")+getValue("S10F14")+getValue("S10F16")+getValue("S10F18")+getValue("S10F20")+getValue("S10F22")+getValue("S10F24")+getValue("S10F26")+getValue("S10F28"));
		if(getValue("S10F29")<0){
			setBNValue("S10F29",0);
		}
		  //ajax String val = TaxValidation.getMinusThePrepaidTax($Cret00BPTTaxpayerUid,$Cret00RetTaxperiod,$Cret00TaxtypeCode,$Cret00BPTVerTaxyear);
		  var s10f30 = 0;
		  if(null!=val){
			s10f30 = val;
		  }
		setBNValue("S10F30",s10f30);
		setBNValue("S10F31",getValue("S10F29")-getValue("S10F29"));
		if(getValue("S10F31")<0){
			setBNValue("S10F31",0);
		}
		setBNValue("S10F32",getValue("S2F20")+getValue("S4F31")+getValue("S6F12"));
		  if(getValue("S10F32") > 0){
		  setBNValue("S10F33", getValue("S10F32")*0.07);
		  }else{
		  setBNValue("S10F33",0);
		  }
		setBNValue("S10F34",getValue("S4F14")+getValue("S4F20")+getValue("S6F3"));
		  if(getValue("S10F34") > 0){
		  setBNValue("S10F35",getValue("S10F34")* 0.07);
		  }else{
		  setBNValue("S10F35",0);
		  }
		setBNValue("S10F36",getValue("S4F21")+getValue("S4F32")+getValue("S6F13"));
		  if(getValue("S10F36") > 0){
		  setBNValue("S10F37",getValue("10F36") * 0.07);
		  }else{
		  setBNValue("S10F37",0);
		  }
		setBNValue("S10F38",getValue("S4F22")+getValue("S4F33")+getValue("S6F14"));
		  if(getValue("S10F38") > 0){
		  setBNValue("S10F39",getValue("S10F38")*0.07");
		  }else{
		  setBNValue("S10F39",0);
		  }
		setBNValue("S10F40",getValue("S10F31")+getValue("S10F33")+getValue("S10F35")+getValue("S10F37")+getValue("S10F39"));
	}
	function schedule11(){
		setBNValue("S11F8",getValue("S11F5")+getValue("S11F6")+getValue("S11F7"));
		setBNValue("S11F9",getValue("S11F9")+getValue("S11F8"));
		setBNValue("S11F20",getValue("S11F17")-getValue("S11F18")-getValue("S11F19"));
		setBNValue("S11F21",getValue("S11F21")+getValue("S11F20"));
		setBNValue("S11F30",getValue("S11F30")+getValue("S11F29"));
	}
	
	return function schedule(){
			schedule1();
			schedule2();
	};
})();


var disableCalculatedInput = (function(){
	var options = {};
	options.prefix = "Cret00RTRTC";
	function disableInput(idSuf){
		$("#"+options.prefix+idSuf).attr("disabled","disabled");
	}
	return function disableCalculatedInput(){
		disableInput("S1F3");
		disableInput("S1F9");
		disableInput("S1F10");
		disableInput("S1F11");
	};
})();

