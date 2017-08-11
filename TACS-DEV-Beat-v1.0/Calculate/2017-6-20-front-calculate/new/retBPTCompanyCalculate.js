/**
 *  for the front calculate method of BPT company return
 */
function disableInput(idSuf){
	$("#Cret00BPTCTRC"+idSuf).attr("disabled","disabled");
}
function disableCalculatedInput(){
	disableInput("S1F7");
	disableInput("S1F8");
	disableInput("S1F29");
	disableInput("S1F30");
	disableInput("S1F31");
	disableInput("S1F32");
	disableInput("S1F39");
	disableInput("S1F40");
	disableInput("S1F51");
	disableInput("S1F52");
	disableInput("S1F53");
	disableInput("S1F54");
	disableInput("S1F55");
	disableInput("S1F56");
	disableInput("S1F57");
	disableInput("S1F58");
	disableInput("S1F67");
	disableInput("S1F68");
	disableInput("S2F4");
	disableInput("S2F9");
	disableInput("S2F11");
	disableInput("S2F12");
	disableInput("S2F13");
	disableInput("S2F23");
	disableInput("S3F1");
	disableInput("S3F18");
	disableInput("S3F19");
	disableInput("S3F25");
	disableInput("S3F28");
	disableInput("S3F37");
	disableInput("S3F29");
	disableInput("S3F31");
	disableInput("S3F36");
	disableInput("S4F4");
	disableInput("S4F9");
	disableInput("S4F15");
	disableInput("S4F18");
	disableInput("S4F22");
	disableInput("S4F23");
	disableInput("S4F24");
	disableInput("S4F34");
	disableInput("S5F1");
	disableInput("S5F18");
	disableInput("S5F19");
	disableInput("S5F25");
	disableInput("S5F28");
	disableInput("S5F37");
	disableInput("S5F29");
	disableInput("S5F31");
	disableInput("S5F36");
	disableInput("S6F4");
	disableInput("S6F5");
	disableInput("S6F15");
	disableInput("S7F1");
	disableInput("S7F18");
	disableInput("S7F19");
	disableInput("S7F25");
	disableInput("S7F28");
	disableInput("S7F37");
	disableInput("S7F29");
	disableInput("S7F31");
	disableInput("S7F36");
	disableInput("S8F5");
	disableInput("S8F6");
	disableInput("S8F7");
	disableInput("S8F8");
	disableInput("S8F9");
	disableInput("S8F10");
	disableInput("S8F11");
	disableInput("S8F12");
	disableInput("S9F6_1");
	disableInput("S9F9_1");
	disableInput("S9F10_1");
	disableInput("S9F11_1");
	disableInput("S9F12_1");
	disableInput("S9F13_1");
	disableInput("S9F14_1");
	disableInput("S9F15");
	disableInput("S10F7_1");
	disableInput("S10F8");
	disableInput("S11F1");
	disableInput("S11F2");
	disableInput("S11F3");
	disableInput("S11F4");
	disableInput("S11F5");
	disableInput("S11F6");
	disableInput("S11F7");
	disableInput("S11F8");
	disableInput("S11F9");
	disableInput("S11F10");
	disableInput("S11F12");
	disableInput("S11F14");
	disableInput("S11F16");
	disableInput("S11F17");
	disableInput("S11F18");
	disableInput("S11F19");
	disableInput("S11F20");
	disableInput("S11F21");
	disableInput("S11F22");
	disableInput("S11F23");
	disableInput("S11F24");
	disableInput("S11F25");
	disableInput("S11F26");
	disableInput("S11F27");
	disableInput("S11F28");
	disableInput("S11F29");
	disableInput("S11F31");
	disableInput("S11F32");
	disableInput("S11F33");
	disableInput("S11F34");
	disableInput("S11F35");
	disableInput("S11F36");
	disableInput("S11F37");
	disableInput("S11F38");
	disableInput("S11F39");
	disableInput("S11F40");
	disableInput("S12F8_1");
	disableInput("S12F9");
	disableInput("S12F20_1");
	disableInput("S12F21");
	disableInput("S12F30");
}
function getMaxValue(val1,val2){
	if(val1>val2){
		return val1;
	}else{
		return val2;
	}
}
function getMinValue(val1,val2){
	if(val1<val2){
		return getMaxValue(val1,0);
	}else{
		return getMaxValue(val2,0);
	}
}
function getJustMinValue(val1,val2){
	if(val1<val2){
		return val1;
	}else{
		return val2;
	}
}
function getValue(code){
	if(""==$("#Cret00BPTCTRC"+code+"hidden").val()){
		return parseFloat(0);
	}else{
		return parseFloat($("#Cret00BPTCTRC"+code+"hidden").val());
	}
}
function setBPTCompanyValue(id,val){
	val = parseFloat(val).toFixed(2);
	$("#Cret00BPTCTRC"+id).val(val);
	//apex.ctrl.format.setValue($(this).attr(id),apex.util.eval($(this).attr("isMoney")));
	apex.ctrl.format.setValue(id,{symbol:'N$',decimal:'.',thousand:',',precision:'2',emptyVal:'0.00',intLen:'18',format:{pos:'%v', neg:'(%v)'}});
	$("input[name='Cret00BPTCTRC"+id+"']").val(val);
}
function schedule1(){
	var s1f7 = getValue("S1F1")+getValue("S1F3")+getValue("S1F5")+getValue("S1F69")+getValue("S1F71");
	setBPTCompanyValue("S1F7",s1f7);
	var s1f8 = getValue("S1F2")+getValue("S1F4")+getValue("S1F6")+getValue("S1F70")+getValue("S1F72");
	setBPTCompanyValue("S1F8",s1f8);
	var s1f29 = getValue("S1F9")+getValue("S1F11")+getValue("S1F13")+getValue("S1F15")+getValue("S1F17")+getValue("S1F19")+getValue("S1F21")+getValue("S1F23")+getValue("S1F25")+getValue("S1F27");
	setBPTCompanyValue("S1F29",s1f29);
	var s1f30 = getValue("S1F10")+getValue("S1F12")+getValue("S1F14")+getValue("S1F16")+getValue("S1F18")+getValue("S1F20")+getValue("S1F22")+getValue("S1F24")+getValue("S1F26")+getValue("S1F28");
	setBPTCompanyValue("S1F30",s1f30);
	var s1f31 = getValue("S1F7")+getValue("S1F29");
	setBPTCompanyValue("S1F31",s1f31);
	var s1f32 = getValue("S1F8")+getValue("S1F30");
	setBPTCompanyValue("S1F32",s1f32);
	setBPTCompanyValue("S1F39",getValue("S1F33")+getValue("S1F35")+getValue("S1F37"));
	setBPTCompanyValue("S1F40",getValue("S1F34")+getValue("S1F36")+getValue("S1F38"));
	var s1f51 = getValue("S1F41")+getValue("S1F43")+getValue("S1F45")+getValue("S1F47")+getValue("S1F49")+getValue("S1F73");
	setBPTCompanyValue("S1F51",s1f51);
	var s1f52 = getValue("S1F42")+getValue("S1F44")+getValue("S1F46")+getValue("S1F48")+getValue("S1F50")+getValue("S1F74");
	setBPTCompanyValue("S1F52",s1f52);
	var s1f53 = getValue("S1F39")+getValue("S1F51");
	setBPTCompanyValue("S1F53",s1f53);
	var s1f54 = getValue("S1F40")+getValue("S1F52");
	setBPTCompanyValue("S1F54",s1f54);
	var s1f55 = getValue("S1F29")-getValue("S1F51");
	setBPTCompanyValue("S1F55",s1f55);
	var s1f56 = getValue("S1F30")-getValue("S1F52");
	setBPTCompanyValue("S1F56",s1f56);
	var s1f57 = s1f7+s1f55;
	setBPTCompanyValue("S1F57",s1f57);
	var s1f58 = s1f8+s1f56;
	setBPTCompanyValue("S1F58",s1f58);
	var s1f67 = getValue("S1F59")+getValue("S1F61")+getValue("S1F63")+getValue("S1F65")+getValue("S1F75");
	setBPTCompanyValue("S1F67",s1f67);
	var s1f68 = getValue("S1F60")+getValue("S1F62")+getValue("S1F64")+getValue("S1F66")+getValue("S1F76");
	setBPTCompanyValue("S1F68",s1f68);
}

function schedule2(){
	var s2f4 = getValue("S2F1")-getValue("S2F3");
	setBPTCompanyValue("S2F4",s2f4);
	var s2f9 = getValue("S2F5")+getValue("S2F6")+getValue("S2F8");
	setBPTCompanyValue("S2F9",s2f9);
	var s2f11 = s2f9 - getValue("S2F10");
	setBPTCompanyValue("S2F11",s2f11);
	var s2f12 = s2f4 - s2f11;
	setBPTCompanyValue("S2F12",s2f12);
	var s2f13 = 0;
	if(s2f11!=0){
		s2f13 = (s2f12/s2f11*100).toFixed(2);
	}
	setBPTCompanyValue("S2F13",s2f13);
	var s2f23 = s2f12 + getValue("S2F14")+getValue("S2F15")+getValue("S2F17")-getValue("S2F18")-getValue("S2F19")-getValue("S2F20")-getValue("S2F21")-getValue("S2F22");
	setBPTCompanyValue("S2F23",s2f23);
}

function schedule3(){
	setBPTCompanyValue("S3F1",getValue("S2F23"));
	var s3f18 = getValue("S3F2")+getValue("S3F3")+getValue("S3F4")+getValue("S3F5")+getValue("S3F6")+getValue("S3F7")+getValue("S3F8")+getValue("S3F9")+getValue("S3F10")+getValue("S3F11")+getValue("S3F12")+getValue("S3F13")+getValue("S3F14")+getValue("S3F15")+getValue("S3F16")+getValue("S3F38")+getValue("S3F38A");
	setBPTCompanyValue("S3F18",s3f18);
	var s3f19 = getValue("S3F1")+s3f18;
	setBPTCompanyValue("S3F19",s3f19);
	var s3f20 = getValue("S9F16");
	setBPTCompanyValue("S3F20",s3f20);
	var s3f21 = getJustMinValue(getValue("S3F21"),getValue("S3F12"));
	setBPTCompanyValue("S3F21",s3f21);
	var s2f23 = 0;
	if(getValue("S2F23")>0){
		s2f23 = getValue("S2F23");
	}
	var s3f25 = getValue("S3F2")+ getMinValue(getValue("S3F4"),s2f23*0.1)+getValue("S3F3")*0.25+previousS3F3*0.25;
	setBPTCompanyValue("S3F25",s3f25);
	var s3f26 = getMaxValue(getValue("S3F26"),getValue("S3F15"));
	setBPTCompanyValue("S3F26",s3f26);
	var s3f28 = getValue("S3F20")+getValue("S3F21")+getValue("S3F22")+getValue("S3F25")+getValue("S3F26")+getValue("S3F39");
	setBPTCompanyValue("S3F28",s3f28);
	var s3f37 = getValue("S3F19")-s3f28;
	setBPTCompanyValue("S3F37",s3f37);
	var s3f29 = s3f37 - getValue("S3F27");
	setBPTCompanyValue("S3F29",s3f29);
	if(getValue("S10F9")>0){
		setBPTCompanyValue("S3F30",getValue("S10F9"));
	}else{
		setBPTCompanyValue("S3F30",0);
	}
	var s3f31 = getValue("S2F14") - getValue("S2F19");
	setBPTCompanyValue("S3F31",s3f31);
	var s3f36 = getValue("S3F29") - getValue("S3F30") - getValue("S3F31") - getValue("S3F32") - getValue("S3F33") - getValue("S3F34") - getValue("S3F35");
	setBPTCompanyValue("S3F36",s3f36);
}

function schedule4(){
	var s4f4 = getValue("S4F1")-getValue("S4F3");
	setBPTCompanyValue("S4F4",s4f4);
	var s4f9 = getValue("S4F5")+getValue("S4F6")+getValue("S4F7")-getValue("S4F8");
	setBPTCompanyValue("S4F9",s4f9);
	var s4f15 = getValue("S4F9")+getValue("S4F10")+getValue("S4F11")+getValue("S4F12")+getValue("S4F13")+getValue("S4F14");
	setBPTCompanyValue("S4F15",s4f15);
	var s4f18 = getValue("S4F15")+getValue("S4F16")-getValue("S4F17");
	setBPTCompanyValue("S4F18",s4f18);
	var s4f22 = getValue("S4F18")+getValue("S4F19")+getValue("S4F20")-getValue("S4F21");
	setBPTCompanyValue("S4F22",s4f22);
	var s4f23 = getValue("S4F4")-s4f22;
	setBPTCompanyValue("S4F23",s4f23);
	var s4f24 = 0;
	if(s4f22!=0){
		s4f24 = s4f23/s4f22*100;
	}
	setBPTCompanyValue("S4F24",s4f24);
	var s4f34 = getValue("S4F23")+getValue("S4F25")+getValue("S4F26")+getValue("S4F28")-getValue("S4F29")-getValue("S4F30")-getValue("S4F31")-getValue("S4F32")-getValue("S4F33");
	setBPTCompanyValue("S4F34",s4f34);
}

function schedule5(){
	setBPTCompanyValue("S5F1",getValue("S4F34"));
	var s5f18 = getValue("S5F2")+getValue("S5F3")+getValue("S5F4")+getValue("S5F5")+getValue("S5F6")+getValue("S5F7")+getValue("S5F8")+getValue("S5F9")+getValue("S5F10")+getValue("S5F11")+getValue("S5F12")+getValue("S5F13")+getValue("S5F14")+getValue("S5F15")+getValue("S5F16")+getValue("S5F38")+getValue("S5F38A");
	setBPTCompanyValue("S5F18",s5f18);
	var s5f19 = getValue("S5F1")+getValue("S5F18");
	setBPTCompanyValue("S5F19",s5f19);
	setBPTCompanyValue("S5F20",getValue("S9F17"));
	var s5f21 = getJustMinValue(getValue("S5F21"),getValue("S5F12"));
	setBPTCompanyValue("S5F21",s5f21);
	var s5f25 = getValue("S5F2")+ getMinValue(getValue("S5F4"),getValue("S4F34")*0.1)+getValue("S5F3")*0.25+previousS5F3*0.25;
	setBPTCompanyValue("S5F25",s5f25);
	var s5f28 = getValue("S5F2")+getValue("S5F21")+getValue("S5F22")+getValue("S5F25")+getValue("S5F26")+getValue("S5F39");
	setBPTCompanyValue("S5F28",s5f28);
	var s5f37 = s5f19-s5f28;
	setBPTCompanyValue("S5F37",s5f37);
	var s5f29 = s5f37-getValue("S5F27");
	setBPTCompanyValue("S5F29",s5f29);
	var s5f31 = getValue("S4F25")-getValue("S4F30");
	setBPTCompanyValue("S5F31",s5f31);
	var s5f36 = getValue("S5F29")-getValue("S5F30")-getValue("S5F31")-getValue("S5F32")-getValue("S5F33")-getValue("S5F34")-getValue("S5F35");
	setBPTCompanyValue("S5F36",s5f36);
}

function schedule6(){
	var s6f4 = getValue("S6F2")+getValue("S6F3");
	setBPTCompanyValue("S6F4",s6f4);
	var s6f5 = getValue("S6F1")-s6f4;
	setBPTCompanyValue("S6F5",s6f5);
	s6f15=s6f5+  getValue("S6F6")+ getValue("S6F7")+ getValue("S6F9")- getValue("S6F10")- getValue("S6F11")- getValue("S6F12")- getValue("S6F13")- getValue("S6F14");
	setBPTCompanyValue("S6F15",s6f15);
}


function schedule7(){
	var s7f1 = getValue("S6F15");
	setBPTCompanyValue("S7F1",s7f1);
	var s7f18 = getValue("S7F2")+getValue("S7F3")+getValue("S7F4")+getValue("S7F5")+getValue("S7F6")+getValue("S7F7")+getValue("S7F8")+getValue("S7F9")+getValue("S7F10")+getValue("S7F11")+getValue("S7F12")+getValue("S7F13")+getValue("S7F14")+getValue("S7F15")+getValue("S7F16")+getValue("S7F38")+getValue("S7F38A");
	setBPTCompanyValue("S7F18",s7f18);
	var s7f19 = s7f1+s7f18;
	setBPTCompanyValue("S7F19",s7f19);
	setBPTCompanyValue("S5F20",getValue("S9F18"));
	var s7f21 = getJustMinValue(getValue("S7F21"),getValue("S7F12"));
	setBPTCompanyValue("S7F21",s7f21);
	var s7f25 = getValue("S7F4")+ getMinValue(getValue("S7F4"),getValue("S6F15")*0.1)+getValue("S7F3")*0.25+previousS7F3*0.25;
	setBPTCompanyValue("S7F25",s7f25);
	var s7f26 = getJustMinValue(getValue("S7F26"),getValue("S6F7"));
	setBPTCompanyValue("S7F26",s7f26);
	var s7f28 = getValue("S7F20")+getValue("S7F21")+getValue("S7F22")+getValue("S7F25")+getValue("S7F26")+getValue("S7F39");
	setBPTCompanyValue("S7F28",s7f28);
	var s7f37 = getValue("S7F19")-getValue("S7F28");
	setBPTCompanyValue("S7F37",s7f37);
	var s7f29 = getValue("S7F37")-getValue("S7F27");
	setBPTCompanyValue("S7F29",s7f29);
	var s10f11 = getValue("S10F11");
	if(s10f11>0){
		setBPTCompanyValue("S7F30",s10f11);
	}
	var s7f31 = getValue("S6F6")-getValue("S6F11");
	setBPTCompanyValue("S7F31",s7f31);
	var s7f36 = getValue("S7F29")-getValue("S7F30")-getValue("S7F31")-getValue("S7F32")-getValue("S7F33")-getValue("S7F34")-getValue("S7F35");
	setBPTCompanyValue("S7F36",s7f36);
}

function schedule8(){
	var s8f5 = 0;
	var s8f6 = 0;
	var s8f7 = 0;
	for(var i=1;i<$("select[id^='Cret00BPTCTRCS8F2_']").length+1;i++){
		if($("select[id='Cret00BPTCTRCS8F2_"+i+"']").val()==="1"){
			s8f5+= getValue("S8F3_"+i);
		}
		if($("select[id='Cret00BPTCTRCS8F2_"+i+"']").val()==="2"){
			s8f6+= getValue("S8F3_"+i);
		}
		if($("select[id='Cret00BPTCTRCS8F2_"+i+"']").val()==="3"){
			s8f7+= getValue("S8F3_"+i);
		}
	}
	setBPTCompanyValue("S8F5",s8f5);
	setBPTCompanyValue("S8F6",s8f6);
	setBPTCompanyValue("S8F7",s8f7);
	var s8f8 = s8f5 + s8f6 + s8f7;
	setBPTCompanyValue("S8F8",s8f8);
	var s8f9 = getValue("S3F36")-getValue("S8F5");
	setBPTCompanyValue("S8F9",s8f9);
	var s8f10 = getValue("S5F36")-getValue("S8F6");
	setBPTCompanyValue("S8F10",s8f10);
	var s8f11 = getValue("S7F36")-getValue("S8F7");
	setBPTCompanyValue("S8F11",s8f11);
	var s8f12 = getValue("S8F9")+getValue("S8F10")+getValue("S8F11");
	setBPTCompanyValue("S8F12",s8f12);
}
function schedule9(){
	var s9f15 = "0";
	for(var i=1;i<$("select[id^='Cret00BPTCTRCS9F2_']").length+1;i++){
		if(""!=$("select[id='Cret00BPTCTRCS9F2_"+i+"']").val()){
			var s9f6Previous = getPreviousTabFieldSameSubTypeValue($("select[id='Cret00BPTCTRCS9F2_"+i+"']").val(),"Cret00BPTCTRCS9F6","tbl_02","Cret00BPTCTRCS9F2");
			if("nothing"!=s9f6Previous){
				setBPTCompanyValue("S9F3_"+i,s9f6Previous);
			}
			var s9f13Previous = getPreviousTabFieldSameSubTypeValue($("select[id='Cret00BPTCTRCS9F2_"+i+"']").val(),"Cret00BPTCTRCS9F13","tbl_02","Cret00BPTCTRCS9F2");
			if("nothing"!=s9f13Previous){
				setBPTCompanyValue("S9F7_"+i,s9f13Previous);
			}
		}
		var s9f6 = getValue("S9F3_"+i)+getValue("S9F4_"+i)+getValue("S9F5_"+i);
		setBPTCompanyValue("S9F6_"+i,s9f6);
		var s9f8 = 0;
		if(null==$("#Cret00BPTCTRCS9F8_"+i).val()||$("#Cret00BPTCTRCS9F8_"+i).val()==""){
			s9f8 = 0;
		}else{
			s9f8 = $("#Cret00BPTCTRCS9F8_"+i).val();
		}
		var s9f9 = parseFloat(getValue("S9F3_"+i)*parseFloat(s9f8)/100).toFixed(2);
		setBPTCompanyValue("S9F9_"+i,s9f9);
		var s9f10 = parseFloat(getValue("S9F4_"+i)*parseFloat(s9f8)/200).toFixed(2);
		setBPTCompanyValue("S9F10_"+i,s9f10);
		var s9f11 = parseFloat(getValue("S9F5_"+i)*parseFloat(s9f8)/200).toFixed(2);
		setBPTCompanyValue("S9F11_"+i,s9f11);
		var s9f12=parseFloat(s9f9)+parseFloat(s9f10)-parseFloat(s9f11); 
		setBPTCompanyValue("S9F12_"+i,s9f12);
		var s9f13 = getValue("S9F7_"+i)+getValue("S9F12_"+i);
		setBPTCompanyValue("S9F13_"+i,s9f13);
		var s9f14 = getValue("S9F6_"+i)-getValue("S9F13_"+i);
		setBPTCompanyValue("S9F14_"+i,s9f14);
		s9f15 += getValue("S9F12_"+i);
	}
	setBPTCompanyValue("S9F15",s9f15);
	
}

function schedule10(){
	var s10f8 = "0";
	for(var i=1;i<$("select[id^='Cret00BPTCTRCS10F2_']").length+1;i++){
		if(""!=$("select[id='Cret00BPTCTRCS10F2_"+i+"']").val()){
			for(var j=1;j<$("select[id^='Cret00BPTCTRCS9F2_']").length+1;j++){
				if(""!=$("select[id='Cret00BPTCTRCS9F2_"+j+"']").val()){
					if($("select[id='Cret00BPTCTRCS9F2_"+j+"']").val()==$("select[id='Cret00BPTCTRCS10F2_"+i+"']").val()){
						s9f5 += getValue("S9F5_"+i);
					}
				}
			}
			setBPTCompanyValue("S10F5_"+i,s9f5);
		}
		var s10f7 = getValue("S10F4_"+i)-getValue("S10F5_"+i)+getValue("S10F6_"+i);
		setBPTCompanyValue("S10F7_"+i,s10f7);
		s10f8+=s10f7;
	}
	setBPTCompanyValue("S10F8",s10f8);
}
function schedule11(){
	var codeBusM=getTaxpayerBus("m");
	var myZero = 0;
	//如果条件为真,是石油和烟草,以下值为0
	if(codeBusM=="10_NAT_TRADE" || codeBusM=="2_NAT_TRADE"){
		setBPTCompanyValue("S11F1",myZero);
		setBPTCompanyValue("S11F2",myZero);
		setBPTCompanyValue("S11F3",myZero);
		setBPTCompanyValue("S11F4",myZero);
		setBPTCompanyValue("S11F5",myZero);
		setBPTCompanyValue("S11F6",myZero);
	}else{
		setBPTCompanyValue("S11F1",getValue("S8F10"));
		setBPTCompanyValue("S11F3",getValue("S8F9"));
		setBPTCompanyValue("S11F5",getValue("S8F11"));
		var s11f2 = getValue("S11F1")*0.1;
		setBPTCompanyValue("S11F2",s11f2);
		var s11f4 = getValue("S11F3")*0.15;
		setBPTCompanyValue("S11F4",s11f4);
		var s11f6 = getValue("S11F5")*0.15;
		setBPTCompanyValue("S11F6",s11f6);
	}
	var s11f7 = getValue("S3F31")+getValue("S5F31")+getValue("S7F31");
	setBPTCompanyValue("S11F7",s11f7);
	setBPTCompanyValue("S11F8",s11f7*0.15);
    if(codeBusM=="2_NAT_TRADE"){
    	setBPTCompanyValue("S11F9",getValue("S8F12"));
    	setBPTCompanyValue("S11F10",getValue("S11F9")*0.3);
    }else{
    	setBPTCompanyValue("S11F9",myZero);
    	setBPTCompanyValue("S11F10",getValue("S11F9")*0.3);
    }
    //判断是否是a
    var codeBusS=getTaxpayerBus("s");
    if(null!=codeBusS&&(codeBusS+"").indexOf("119_NAT_ACTIVITY",0)!=-1){
    	setBPTCompanyValue("S11F11",getValue("S8F12"));
    }else{
    	setBPTCompanyValue("S11F11",myZero);
    }
    setBPTCompanyValue("S11F12",getValue("S11F11")*0.35);
    if(null!=codeBusS&&((codeBusS+"").indexOf("54_NAT_ACTIVITY",0)!=-1||(codeBusS+"").indexOf("105_NAT_ACTIVITY",0)!=-1)){
    	setBPTCompanyValue("S11F13",getValue("S8F12"));
    }else{
    	setBPTCompanyValue("S11F13",myZero);
    }
    setBPTCompanyValue("S11F14",getValue("S11F13")*0.15);
    if(codeBusM=="12_NAT_TRADE"){  
    	setBPTCompanyValue("S11F15",getValue("S8F12"));
    }else{
    	setBPTCompanyValue("S11F15",myZero);
    }
    setBPTCompanyValue("S11F16",getValue("S11F15")*0.15);
    var taxTypeCode = $("#Cret00TaxtypeCode").val();
    if("BPT-L"==taxTypeCode||"BPT-F"==taxTypeCode){
    	setBPTCompanyValue("S11F19",getValue("S8F8"));
    }else if("DT-L"==taxTypeCode||"DT-F"==taxTypeCode){
    	setBPTCompanyValue("S11F19",getValue("S8F12"));
    }else{
    	setBPTCompanyValue("S11F19",myZero);
    }
    setBPTCompanyValue("S11F17",getValue("S10F8"));
    if(getValue("S11F17")>0){
    	setBPTCompanyValue("S11F18",getValue("S11F17")*0.15);
    }else{
    	setBPTCompanyValue("S11F18",myZero);
    }
    if(getValue("S11F19")>0){
    	setBPTCompanyValue("S11F20",getValue("S11F19")*0.05);
    }else{
    	setBPTCompanyValue("S11F20",myZero);
    }
    setBPTCompanyValue("S11F21",getValue("S3F32")+getValue("S5F32")+getValue("S7F32"));
    if(getValue("S11F21")>0){
    	setBPTCompanyValue("S11F22",getValue("S11F21")*0.02);
    }else{
    	setBPTCompanyValue("S11F22",myZero);
    }
    setBPTCompanyValue("S11F23",getValue("S3F33")+getValue("S5F33")+getValue("S7F33"));
    if(getValue("S11F23")>0){
    	setBPTCompanyValue("S11F24",getValue("S11F23")*0.02);
    }else{
    	setBPTCompanyValue("S11F24",myZero);
    }
    setBPTCompanyValue("S11F25",getValue("S3F34")+getValue("S5F34")+getValue("S7F34"));
    if(getValue("S11F25")>0){
    	 setBPTCompanyValue("S11F26",getValue("S11F25")*0.02);
    }else{
    	setBPTCompanyValue("S11F26",myZero);
    }
    setBPTCompanyValue("S11F27",getValue("S3F35")+getValue("S5F35")+getValue("S7F35"));
    if(getValue("S11F27")>0){
    	setBPTCompanyValue("S11F28",getValue("S11F27")*0.02);
   }else{
   	setBPTCompanyValue("S11F28",myZero);
   }
    setBPTCompanyValue("S11F29",getValue("S11F28")+getValue("S11F2")+getValue("S11F4")+getValue("S11F6")+getValue("S11F8")+getValue("S11F10")+getValue("S11F12")+getValue("S11F14")+getValue("S11F16")+getValue("S11F18")+getValue("S11F20")+getValue("S11F22")+getValue("S11F24")+getValue("S11F26"));
    if(getValue("S11F29")<0){
    	setBPTCompanyValue("S11F29",myZero);
    }
    var val = getMinusThePrepaidTax();
    if(null!=val&&val!=""){
    	setBPTCompanyValue("S11F30",val);
    	setBPTCompanyValue("S11F31",getValue("S11F29")-val);
    }else{
    	setBPTCompanyValue("S11F30",myZero);
    	setBPTCompanyValue("S11F31",getValue("S11F29"));
    }
    if(getValue("S11F31")<0){
    	setBPTCompanyValue("S11F31",myZero);
    }
    setBPTCompanyValue("S11F32",getValue("S2F20")+getValue("S4F31")+getValue("S6F12"));
    if(getValue("S11F32")>0){
    	setBPTCompanyValue("S11F33",getValue("S11F32")*0.15);
    }else{
    	setBPTCompanyValue("S11F33",myZero);
    }
    setBPTCompanyValue("S11F34",getValue("S4F14")+getValue("S4F20")+getValue("S6F3"));
    if(getValue("S11F34")>0){
    	setBPTCompanyValue("S11F35",getValue("S11F34")*0.15);
    }else{
    	setBPTCompanyValue("S11F35",myZero);
    }
    setBPTCompanyValue("S11F36",getValue("S2F21")+getValue("S4F32")+getValue("S6F13"));
    if(getValue("S11F36")>0){
    	setBPTCompanyValue("S11F37",parseFloat(getValue("S11F36")*0.15).toFixed(2));
    }else{
    	setBPTCompanyValue("S11F37",myZero);
    }
    setBPTCompanyValue("S11F38",getValue("S2F22")+getValue("S4F33")+getValue("S6F14"));
    if(getValue("S11F38")>0){
    	setBPTCompanyValue("S11F39",getValue("S11F38")*0.15);
    }else{
    	setBPTCompanyValue("S11F39",myZero);
    }
    setBPTCompanyValue("S11F40",getValue("S11F31")+getValue("S11F33")+getValue("S11F35")+getValue("S11F37")+getValue("S11F39"));
}
function schedule12(){
	var s12f9 = 0;
	for(var i=1;i<$("input[id^='Cret00BPTCTRCS12F2_']").length+1;i++){
		var s12f8 = getValue("S12F5_"+i)+getValue("S12F6_"+i)+getValue("S12F7_"+i);
		setBPTCompanyValue("S12F8_"+i,s12f8);
		s12f9 += s12f8;
	}
	setBPTCompanyValue("S12F9",s12f9);
	var s12f21 = 0;
	for(var i=1;i<$("input[id^='Cret00BPTCTRCS12F14_']").length+1;i++){
		var s12f20 = getValue("S12F17_"+i)-getValue("S12F18_"+i)-getValue("S12F19_"+i);
		setBPTCompanyValue("S12F20_"+i,s12f20);
		s12f21 += s12f20;
	}
	setBPTCompanyValue("S12F21",s12f21);
	var s12f30 = 0;
	for(var i=1;i<$("input[id^='Cret00BPTCTRCS12F26_']").length+1;i++){
		s12f30 += getValue("S12F29_"+i);
	}
	setBPTCompanyValue("S12F30",s12f30);
}
function getMinusThePrepaidTax(type){
	var taxPayerUid = $("#Cret00BPTTaxpayerUid").val();
	var taxTypeCode = $("#Cret00TaxtypeCode").val();
	var taxPeriod = $("#Cret00RetTaxperiod").val();
	var taxYear = $("#Cret00BPTVerTaxyear").val();
	var returnVlaue= 0 ;
	$.ajax({
		 type:'post',
		 url:'getMinusThePrepaidTax.do',
		 data:{"taxPayerUid":taxPayerUid,"taxTypeCode":taxTypeCode,"taxPeriod":taxPeriod,"taxYear":taxYear},
		 dataType:'json',
		 async: false,
		 success:function(data){
			 returnVlaue = data.val;
		 }
	});
	return returnVlaue;
}
function getTaxpayerBus(type){
	var taxPayerUid = $("#Cret00BPTTaxpayerUid").val();
	var tin = $("#Cret00BPTcreg01Tin").val();
	var returnVlaue = "";
	$.ajax({
		 type:'post',
		 url:'getTaxpayerBus.do',
		 data:{"taxPayerUid":taxPayerUid,"tin":tin,"type":type},
		 dataType:'json',
		 async: false,
		 success:function(data){
			 returnVlaue = data.val;
		 }
	});
	return returnVlaue;
}
/*
 * 计算顺序1>8>9>10>2>3>4>5>6>7>11>12
 */
function getPreviousTabFieldSameSubTypeValue(subType,fieldName,tabTag,subTypeCode){
	var versionUid = $("#Cret00BPTRetVerUid").val();
	var returnVlaue = "0";
	debugger;
	$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValueSameSubType.do',
		 data:{"cret03versionUid":versionUid,"fieldName":fieldName,"subType":subType,"subTypeCode":subTypeCode,"tabTag":tabTag},
		 dataType:'json',
		 async: false,
		 success:function(data){
			 returnVlaue = data.val;
		 }
	});
	return returnVlaue;
}
function addCalculateButton(){
	if("${appLangCode}"=="ar_SA"){
		$("#accordion2").before('<button type="button" class="btn btn-primary" id="butCalculate" > حساب</button>');
	}else{
		$("#accordion2").before('<button type="button" class="btn btn-primary" id="butCalculate" >Calculate</button>');
	}
}
$(function(){
	disableCalculatedInput();
	previousS3F3 = 0;
	previousS5F3 = 0;
	previousS7F3 = 0;
	var versionUid = $("#Cret00BPTRetVerUid").val();
	$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRCS3F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS3F3 = data.val;
		 }
	});
	$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRCS5F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS5F3 = data.val;
		 }
	});
	$.ajax({
		 type:'post',
		 url:'getBPTCompanyPreviousFieldValue.do',
		 data:{"cret03versionUid":versionUid,"fieldName":"Cret00BPTCTRCS7F3"},
		 dataType:'json',
		 async: true,
		 success:function(data){
			 previousS7F3 = data.val;
		 }
	});
});
