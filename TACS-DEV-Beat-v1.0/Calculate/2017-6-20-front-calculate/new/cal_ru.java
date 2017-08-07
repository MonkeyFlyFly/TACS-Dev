package BPTBusinessName

dialect  "mvel"

import com.cacss.apex.web.util.rule.TaxField;
import com.cacss.itas.ret.rule.TaxMathUtils;
import com.cacss.itas.ret.rule.AssessmentResult;
import com.cacss.itas.ret.rule.OperatorWrapper;
import com.cacss.itas.ret.rule.TaxValidation;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

//declare any global variables here
global AssessmentResult assResult;

//-----------function: start-----------------------------
//Commercial, Services and Professional: Tax Rates
function String calcCommercialRate(String v) {
  if(v == null) {
    return String.valueOf(0.00);
  }
  String payable = null;
  if(TaxMathUtils.compareTo("3000", v) >= 0) {
    payable = String.valueOf(0.00);
  }else if(TaxMathUtils.compareTo("6000", v) >= 0) {
    payable = TaxMathUtils.mulitplyTax(TaxMathUtils.sub(v,"3000"), "0.05");
  }else if(TaxMathUtils.compareTo("10000", v) >= 0) {
    payable = TaxMathUtils.sum(TaxMathUtils.mulitplyTax(TaxMathUtils.sub(v,"6000"), "0.1"), "150");
  }else {
    payable = TaxMathUtils.sum(TaxMathUtils.mulitplyTax(TaxMathUtils.sub(v,"10000"), "0.15"), "150", "400");
  }
  return payable;
}
//Industrial – Real Estates Business: Tax Rates
function String calcIndustrialRate(String v) {
  if(v == null) {
    return String.valueOf(0.00);
  }
  String payable = null;
  if(TaxMathUtils.compareTo("3000", v) >= 0) {
    payable = String.valueOf(0.00);
  }else {
    payable = TaxMathUtils.mulitplyTax(TaxMathUtils.sub(v,"3000"), "0.1");
  }
  return payable;
}
//-----------function: end  -----------------------------

//----------Schedule 1: start -------------------------
//Schedule 1 : Balance Sheet [1- Noncurrent assets; 2- Current assets]
rule "calc_S1_Assets"
    when
        //1- Noncurrent assets
        $Cret00BPTCTRBNS1F1:TaxField(fieldName == "Cret00BPTCTRBNS1F1");
        $Cret00BPTCTRBNS1F3:TaxField(fieldName == "Cret00BPTCTRBNS1F3");
        $Cret00BPTCTRBNS1F5:TaxField(fieldName == "Cret00BPTCTRBNS1F5");
  $Cret00BPTCTRBNS1F69:TaxField(fieldName == "Cret00BPTCTRBNS1F69");
  $Cret00BPTCTRBNS1F71:TaxField(fieldName == "Cret00BPTCTRBNS1F71");
        $Cret00BPTCTRBNS1F7:TaxField(fieldName == "Cret00BPTCTRBNS1F7",calValue==null);

        $Cret00BPTCTRBNS1F2:TaxField(fieldName == "Cret00BPTCTRBNS1F2");
        $Cret00BPTCTRBNS1F4:TaxField(fieldName == "Cret00BPTCTRBNS1F4");
        $Cret00BPTCTRBNS1F6:TaxField(fieldName == "Cret00BPTCTRBNS1F6");
  $Cret00BPTCTRBNS1F70:TaxField(fieldName == "Cret00BPTCTRBNS1F70");
  $Cret00BPTCTRBNS1F72:TaxField(fieldName == "Cret00BPTCTRBNS1F72");
        $Cret00BPTCTRBNS1F8:TaxField(fieldName == "Cret00BPTCTRBNS1F8",calValue==null);

        //2- Current assets
        $Cret00BPTCTRBNS1F9:TaxField(fieldName == "Cret00BPTCTRBNS1F9");
        $Cret00BPTCTRBNS1F11:TaxField(fieldName == "Cret00BPTCTRBNS1F11");
        $Cret00BPTCTRBNS1F13:TaxField(fieldName == "Cret00BPTCTRBNS1F13");
        $Cret00BPTCTRBNS1F15:TaxField(fieldName == "Cret00BPTCTRBNS1F15");
        $Cret00BPTCTRBNS1F17:TaxField(fieldName == "Cret00BPTCTRBNS1F17");
        $Cret00BPTCTRBNS1F19:TaxField(fieldName == "Cret00BPTCTRBNS1F19");
        $Cret00BPTCTRBNS1F21:TaxField(fieldName == "Cret00BPTCTRBNS1F21");
        $Cret00BPTCTRBNS1F23:TaxField(fieldName == "Cret00BPTCTRBNS1F23");
        $Cret00BPTCTRBNS1F25:TaxField(fieldName == "Cret00BPTCTRBNS1F25");
        $Cret00BPTCTRBNS1F27:TaxField(fieldName == "Cret00BPTCTRBNS1F27");      
        $Cret00BPTCTRBNS1F29:TaxField(fieldName == "Cret00BPTCTRBNS1F29",calValue==null);
        
        $Cret00BPTCTRBNS1F10:TaxField(fieldName == "Cret00BPTCTRBNS1F10");
        $Cret00BPTCTRBNS1F12:TaxField(fieldName == "Cret00BPTCTRBNS1F12");
        $Cret00BPTCTRBNS1F14:TaxField(fieldName == "Cret00BPTCTRBNS1F14");
        $Cret00BPTCTRBNS1F16:TaxField(fieldName == "Cret00BPTCTRBNS1F16");
        $Cret00BPTCTRBNS1F18:TaxField(fieldName == "Cret00BPTCTRBNS1F18");
        $Cret00BPTCTRBNS1F20:TaxField(fieldName == "Cret00BPTCTRBNS1F20");
        $Cret00BPTCTRBNS1F22:TaxField(fieldName == "Cret00BPTCTRBNS1F22");
        $Cret00BPTCTRBNS1F24:TaxField(fieldName == "Cret00BPTCTRBNS1F24");
        $Cret00BPTCTRBNS1F26:TaxField(fieldName == "Cret00BPTCTRBNS1F26");
        $Cret00BPTCTRBNS1F28:TaxField(fieldName == "Cret00BPTCTRBNS1F28");
        $Cret00BPTCTRBNS1F30:TaxField(fieldName == "Cret00BPTCTRBNS1F30",calValue==null);
        
  //Total Assets (Noncurrent assets + Current assets)
        $Cret00BPTCTRBNS1F31:TaxField(fieldName == "Cret00BPTCTRBNS1F31",calValue==null);
        $Cret00BPTCTRBNS1F32:TaxField(fieldName == "Cret00BPTCTRBNS1F32",calValue==null);
    then
  //S1F7=S1F1+S1F3+S1F5+S1F69+S1F71
        $Cret00BPTCTRBNS1F7.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F1,$Cret00BPTCTRBNS1F3,$Cret00BPTCTRBNS1F5,$Cret00BPTCTRBNS1F69,$Cret00BPTCTRBNS1F71));
        assResult.compareAndSet($Cret00BPTCTRBNS1F7);
        
  //S1F8=S1F2+S1F4+S1F6+S1F70+S1F72
        $Cret00BPTCTRBNS1F8.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F2,$Cret00BPTCTRBNS1F4,$Cret00BPTCTRBNS1F6,$Cret00BPTCTRBNS1F70,$Cret00BPTCTRBNS1F72));
        assResult.compareAndSet($Cret00BPTCTRBNS1F8);
        

  //S1F29=S1F9+S1F11..+S1F27 (Uneven number)
        $Cret00BPTCTRBNS1F29.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F9,$Cret00BPTCTRBNS1F11,$Cret00BPTCTRBNS1F13,$Cret00BPTCTRBNS1F15,
    $Cret00BPTCTRBNS1F17,$Cret00BPTCTRBNS1F19,$Cret00BPTCTRBNS1F21,$Cret00BPTCTRBNS1F23,$Cret00BPTCTRBNS1F25,$Cret00BPTCTRBNS1F27));
        assResult.compareAndSet($Cret00BPTCTRBNS1F29);
        
  //S1F30=S1F10+S1F12..+S1F28 (Even number)
        $Cret00BPTCTRBNS1F30.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F10,$Cret00BPTCTRBNS1F12,$Cret00BPTCTRBNS1F14,$Cret00BPTCTRBNS1F16,
    $Cret00BPTCTRBNS1F18,$Cret00BPTCTRBNS1F20,$Cret00BPTCTRBNS1F22,$Cret00BPTCTRBNS1F24,$Cret00BPTCTRBNS1F26,$Cret00BPTCTRBNS1F28));
        assResult.compareAndSet($Cret00BPTCTRBNS1F30);
        

        //S1F31=S1F7+S1F29
        $Cret00BPTCTRBNS1F31.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F7,$Cret00BPTCTRBNS1F29));
        assResult.compareAndSet($Cret00BPTCTRBNS1F31);
        
  //S1F32=S1F8+S1F30
        $Cret00BPTCTRBNS1F32.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F8,$Cret00BPTCTRBNS1F30));
        assResult.compareAndSet($Cret00BPTCTRBNS1F32);
        
  //update($Cret00BPTCTRBNS1F7);
        //update($Cret00BPTCTRBNS1F8);
        //update($Cret00BPTCTRBNS1F29);
        //update($Cret00BPTCTRBNS1F30);
        //update($Cret00BPTCTRBNS1F31);
        //update($Cret00BPTCTRBNS1F32);
end

//Schedule 1 : Balance Sheet [3- Noncurrent liability]
rule "calc_S1_Noncurrent_Liability"
    when
  $Cret00BPTCTRBNS1F33:TaxField(fieldName == "Cret00BPTCTRBNS1F33");
  $Cret00BPTCTRBNS1F35:TaxField(fieldName == "Cret00BPTCTRBNS1F35");
  $Cret00BPTCTRBNS1F37:TaxField(fieldName == "Cret00BPTCTRBNS1F37");
  $Cret00BPTCTRBNS1F39:TaxField(fieldName == "Cret00BPTCTRBNS1F39", calValue==null);

  $Cret00BPTCTRBNS1F34:TaxField(fieldName == "Cret00BPTCTRBNS1F34");
  $Cret00BPTCTRBNS1F36:TaxField(fieldName == "Cret00BPTCTRBNS1F36");
  $Cret00BPTCTRBNS1F38:TaxField(fieldName == "Cret00BPTCTRBNS1F38");
  $Cret00BPTCTRBNS1F40:TaxField(fieldName == "Cret00BPTCTRBNS1F40", calValue==null);
    then
  //S1F39=S1F33+S1F35+S1F37
        $Cret00BPTCTRBNS1F39.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F33,$Cret00BPTCTRBNS1F35,$Cret00BPTCTRBNS1F37));
        assResult.compareAndSet($Cret00BPTCTRBNS1F39);

  $Cret00BPTCTRBNS1F40.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F34,$Cret00BPTCTRBNS1F36,$Cret00BPTCTRBNS1F38));
  assResult.compareAndSet($Cret00BPTCTRBNS1F40);

  //update($Cret00BPTCTRBNS1F39);
  //update($Cret00BPTCTRBNS1F40);
end

//Schedule 1 : Balance Sheet [4- Current liabilities]
rule "calc_S1_Current_Liabilities"
    when
  $Cret00BPTCTRBNS1F41:TaxField(fieldName == "Cret00BPTCTRBNS1F41");
  $Cret00BPTCTRBNS1F43:TaxField(fieldName == "Cret00BPTCTRBNS1F43");
  $Cret00BPTCTRBNS1F45:TaxField(fieldName == "Cret00BPTCTRBNS1F45");
  $Cret00BPTCTRBNS1F47:TaxField(fieldName == "Cret00BPTCTRBNS1F47");
  $Cret00BPTCTRBNS1F49:TaxField(fieldName == "Cret00BPTCTRBNS1F49");
  $Cret00BPTCTRBNS1F51:TaxField(fieldName == "Cret00BPTCTRBNS1F51" , calValue==null);

  $Cret00BPTCTRBNS1F42:TaxField(fieldName == "Cret00BPTCTRBNS1F42");
  $Cret00BPTCTRBNS1F44:TaxField(fieldName == "Cret00BPTCTRBNS1F44");
  $Cret00BPTCTRBNS1F46:TaxField(fieldName == "Cret00BPTCTRBNS1F46");
  $Cret00BPTCTRBNS1F48:TaxField(fieldName == "Cret00BPTCTRBNS1F48");
  $Cret00BPTCTRBNS1F50:TaxField(fieldName == "Cret00BPTCTRBNS1F50");
  $Cret00BPTCTRBNS1F52:TaxField(fieldName == "Cret00BPTCTRBNS1F52" , calValue==null);

  $Cret00BPTCTRBNS1F53:TaxField(fieldName == "Cret00BPTCTRBNS1F53" , calValue==null);
  $Cret00BPTCTRBNS1F54:TaxField(fieldName == "Cret00BPTCTRBNS1F54" , calValue==null);
  $Cret00BPTCTRBNS1F39:TaxField(fieldName == "Cret00BPTCTRBNS1F39");
  $Cret00BPTCTRBNS1F40:TaxField(fieldName == "Cret00BPTCTRBNS1F40");
  $Cret00BPTCTRBNS1F73:TaxField(fieldName == "Cret00BPTCTRBNS1F73");
  $Cret00BPTCTRBNS1F74:TaxField(fieldName == "Cret00BPTCTRBNS1F74");
    then
  //S1F51=S1F41+S1F43..+S1F49+S1F73 (Uneven number)
        $Cret00BPTCTRBNS1F51.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F41,$Cret00BPTCTRBNS1F43,$Cret00BPTCTRBNS1F45,
    $Cret00BPTCTRBNS1F47,$Cret00BPTCTRBNS1F49,$Cret00BPTCTRBNS1F73));
        assResult.compareAndSet($Cret00BPTCTRBNS1F51);

  //S1F52=S1F42+S1F44..+S1F50+S1F74 (Even number)
  $Cret00BPTCTRBNS1F52.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F42,$Cret00BPTCTRBNS1F44,$Cret00BPTCTRBNS1F46,
    $Cret00BPTCTRBNS1F48,$Cret00BPTCTRBNS1F50,$Cret00BPTCTRBNS1F74));
  assResult.compareAndSet($Cret00BPTCTRBNS1F52);

  //update($Cret00BPTCTRBNS1F51);
  //update($Cret00BPTCTRBNS1F52);

  //S1F53=S1F39+S1F51
  $Cret00BPTCTRBNS1F53.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F39,$Cret00BPTCTRBNS1F51));
  assResult.compareAndSet($Cret00BPTCTRBNS1F53);
  //update($Cret00BPTCTRBNS1F53);
    
  //S1F54=S1F40+S1F52
  $Cret00BPTCTRBNS1F54.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F40,$Cret00BPTCTRBNS1F52));
  assResult.compareAndSet($Cret00BPTCTRBNS1F54);
  //update($Cret00BPTCTRBNS1F54);
end

//Schedule 1 : Balance Sheet [Operating capital.(Current Assets – Current Liabilities)]
rule "calc_S1_Operating_capital"
    when
  $Cret00BPTCTRBNS1F29:TaxField(fieldName == "Cret00BPTCTRBNS1F29");
  $Cret00BPTCTRBNS1F51:TaxField(fieldName == "Cret00BPTCTRBNS1F51");
  $Cret00BPTCTRBNS1F55:TaxField(fieldName == "Cret00BPTCTRBNS1F55", calValue==null);

  $Cret00BPTCTRBNS1F30:TaxField(fieldName == "Cret00BPTCTRBNS1F30");
  $Cret00BPTCTRBNS1F52:TaxField(fieldName == "Cret00BPTCTRBNS1F52");
  $Cret00BPTCTRBNS1F56:TaxField(fieldName == "Cret00BPTCTRBNS1F56", calValue==null);
    then
  //S1F55=S1F29-S1F51
  $Cret00BPTCTRBNS1F55.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS1F29,$Cret00BPTCTRBNS1F51));
  assResult.compareAndSet($Cret00BPTCTRBNS1F55);
       
  //S1F56=S1F30-S1F52
  $Cret00BPTCTRBNS1F56.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS1F30,$Cret00BPTCTRBNS1F52));
  assResult.compareAndSet($Cret00BPTCTRBNS1F56);
end

//Schedule 1 : Balance Sheet[Total investments.(Noncurrent Assets +/- Operation capital)]
rule "calc_S1_Total_investments_S1f57"
    when
  $Cret00BPTCTRBNS1F7:TaxField(fieldName == "Cret00BPTCTRBNS1F7");
  $Cret00BPTCTRBNS1F55:TaxField(fieldName == "Cret00BPTCTRBNS1F55");
  $Cret00BPTCTRBNS1F57:TaxField(fieldName == "Cret00BPTCTRBNS1F57", calValue==null);
    then
  
  String s1f55 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS1F55);
  /*
  if(TaxMathUtils.compareTo(s1f55,"0") >= 0){
    $Cret00BPTCTRBNS1F57.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F7,$Cret00BPTCTRBNS1F55));
  }else{
    $Cret00BPTCTRBNS1F57.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS1F7,$Cret00BPTCTRBNS1F55));
  }
  */
  //if S1F55 is positive, S1F57=S1F7+S1F55, otherwise S1F57=S1F7-(Math.abs(S1F55))
  $Cret00BPTCTRBNS1F57.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F7,$Cret00BPTCTRBNS1F55));
  assResult.compareAndSet($Cret00BPTCTRBNS1F57);
end

//Schedule 1 : Balance Sheet[Total investments.(Noncurrent Assets +/- Operation capital)]
rule "calc_S1_Total_investments_S1f58"  
    when
  $Cret00BPTCTRBNS1F8:TaxField(fieldName == "Cret00BPTCTRBNS1F8");
  $Cret00BPTCTRBNS1F56:TaxField(fieldName == "Cret00BPTCTRBNS1F56");
  $Cret00BPTCTRBNS1F58:TaxField(fieldName == "Cret00BPTCTRBNS1F58", calValue==null);
    then
  //if S1F56 is positive, S1F58=S1F8+S1F56, otherwise S1F58=S1F8-S1F56
  String s1f56 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS1F56);
  /*
  if(TaxMathUtils.compareTo(s1f56,"0") >= 0){
    $Cret00BPTCTRBNS1F58.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F8,$Cret00BPTCTRBNS1F56));
  }else{
    $Cret00BPTCTRBNS1F58.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS1F8,$Cret00BPTCTRBNS1F56));
  }
  */
  //if S1F56 is positive, S1F58=S1F8+S1F56, otherwise S1F58=S1F8-(Math.abs(S1F56))
  $Cret00BPTCTRBNS1F58.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F8,$Cret00BPTCTRBNS1F56));
  assResult.compareAndSet($Cret00BPTCTRBNS1F58);
end

//Schedule 1 : Balance Sheet [5- Shareholders equities]
rule "calc_S1_Shareholders_equities"
    when
  $Cret00BPTCTRBNS1F59:TaxField(fieldName == "Cret00BPTCTRBNS1F59");
  $Cret00BPTCTRBNS1F61:TaxField(fieldName == "Cret00BPTCTRBNS1F61");
  $Cret00BPTCTRBNS1F63:TaxField(fieldName == "Cret00BPTCTRBNS1F63");
  $Cret00BPTCTRBNS1F65:TaxField(fieldName == "Cret00BPTCTRBNS1F65");
  $Cret00BPTCTRBNS1F67:TaxField(fieldName == "Cret00BPTCTRBNS1F67",calValue==null);
    
  $Cret00BPTCTRBNS1F60:TaxField(fieldName == "Cret00BPTCTRBNS1F60");
  $Cret00BPTCTRBNS1F62:TaxField(fieldName == "Cret00BPTCTRBNS1F62");
  $Cret00BPTCTRBNS1F64:TaxField(fieldName == "Cret00BPTCTRBNS1F64");
  $Cret00BPTCTRBNS1F66:TaxField(fieldName == "Cret00BPTCTRBNS1F66");
  $Cret00BPTCTRBNS1F68:TaxField(fieldName == "Cret00BPTCTRBNS1F68",calValue==null);
  $Cret00BPTCTRBNS1F75:TaxField(fieldName == "Cret00BPTCTRBNS1F75");
  $Cret00BPTCTRBNS1F76:TaxField(fieldName == "Cret00BPTCTRBNS1F76");
    then
  //S1F67=S1F59+S1F61+S1F63+S1F65+S1F75
  $Cret00BPTCTRBNS1F67.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F59,$Cret00BPTCTRBNS1F61,$Cret00BPTCTRBNS1F63,
    $Cret00BPTCTRBNS1F65,$Cret00BPTCTRBNS1F75));
  assResult.compareAndSet($Cret00BPTCTRBNS1F67);
       
        //S1F68=S1F60+S1F62+S1F64+S1F66+S1F76
  $Cret00BPTCTRBNS1F68.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS1F60,$Cret00BPTCTRBNS1F62,$Cret00BPTCTRBNS1F64,
    $Cret00BPTCTRBNS1F66,$Cret00BPTCTRBNS1F76));
  assResult.compareAndSet($Cret00BPTCTRBNS1F68);
end
//----------Schedule 1: end -------------------------

//----------Schedule 2: start-------------------------
//Schedule 2 : Income Statement for Commercial Business (A) [1: S2F4=S2F1-S2F3]
rule "calc_S2_Cret00BPTCTRBNS2F4"
    when
        $Cret00BPTCTRBNS2F1:TaxField(fieldName == "Cret00BPTCTRBNS2F1");
  $Cret00BPTCTRBNS2F3:TaxField(fieldName == "Cret00BPTCTRBNS2F3");
  $Cret00BPTCTRBNS2F4:TaxField(fieldName == "Cret00BPTCTRBNS2F4",calValue==null);
    then
  //S2F4=S2F1-S2F3
  $Cret00BPTCTRBNS2F4.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS2F1,$Cret00BPTCTRBNS2F3));
  assResult.compareAndSet($Cret00BPTCTRBNS2F4);
  //update($Cret00BPTCTRBNS2F4);
end

//Schedule 2 : Income Statement for Commercial Business (A) [2: S2F9=S2F5+S2F6+S2F8]
rule "calc_S2_Cret00BPTCTRBNS2F9"
    when
        $Cret00BPTCTRBNS2F5:TaxField(fieldName == "Cret00BPTCTRBNS2F5");
  $Cret00BPTCTRBNS2F6:TaxField(fieldName == "Cret00BPTCTRBNS2F6");
  $Cret00BPTCTRBNS2F8:TaxField(fieldName == "Cret00BPTCTRBNS2F8");
  $Cret00BPTCTRBNS2F9:TaxField(fieldName == "Cret00BPTCTRBNS2F9",calValue==null);
    then
  $Cret00BPTCTRBNS2F9.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F5,$Cret00BPTCTRBNS2F6,$Cret00BPTCTRBNS2F8));
  assResult.compareAndSet($Cret00BPTCTRBNS2F9);
  //update($Cret00BPTCTRBNS2F9);
end

//Schedule 2 : Income Statement for Commercial Business (A) [3: S2F11=S2F9-S2F10]
rule "calc_S2_Cret00BPTCTRBNS2F11"
    when
  $Cret00BPTCTRBNS2F9:TaxField(fieldName == "Cret00BPTCTRBNS2F9");
  $Cret00BPTCTRBNS2F10:TaxField(fieldName == "Cret00BPTCTRBNS2F10");
  $Cret00BPTCTRBNS2F11:TaxField(fieldName == "Cret00BPTCTRBNS2F11",calValue==null);
    then
  $Cret00BPTCTRBNS2F11.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS2F9,$Cret00BPTCTRBNS2F10));
  assResult.compareAndSet($Cret00BPTCTRBNS2F11);
  //update($Cret00BPTCTRBNS2F11);
end

//Schedule 2 : Income Statement for Commercial Business (A) [4: S2F12=S2F4-S2F11]
rule "calc_S2_Cret00BPTCTRBNS2F12"
    when
  $Cret00BPTCTRBNS2F4:TaxField(fieldName == "Cret00BPTCTRBNS2F4");
  $Cret00BPTCTRBNS2F11:TaxField(fieldName == "Cret00BPTCTRBNS2F11");
  $Cret00BPTCTRBNS2F12:TaxField(fieldName == "Cret00BPTCTRBNS2F12",calValue==null);
    then
  $Cret00BPTCTRBNS2F12.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS2F4,$Cret00BPTCTRBNS2F11));
  assResult.compareAndSet($Cret00BPTCTRBNS2F12);
  //update($Cret00BPTCTRBNS2F12);
end

//Schedule 2 : Income Statement for Commercial Business (A) [5: S2F13=S2F12/S2F11 (Percentage)]
rule "calc_S2_Cret00BPTCTRBNS2F13"
    when
  $Cret00BPTCTRBNS2F11:TaxField(fieldName == "Cret00BPTCTRBNS2F11");
  $Cret00BPTCTRBNS2F12:TaxField(fieldName == "Cret00BPTCTRBNS2F12");
   $Cret00BPTCTRBNS2F13:TaxField(fieldName == "Cret00BPTCTRBNS2F13",calValue==null);
    then
  String m100v = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS2F12.getNeedValue(), "100");
  $Cret00BPTCTRBNS2F13.setCalValue(TaxMathUtils.division(m100v, $Cret00BPTCTRBNS2F11.getNeedValue()));
  assResult.compareAndSet($Cret00BPTCTRBNS2F13);
  //update($Cret00BPTCTRBNS2F13);
end

//Schedule 2 : Income Statement for Commercial Business (A) [6: S2F23=S2F12+S2F14+S2F15+S2F17-S2F18-S2F19-S2F20-S2F21-S2F22]
rule "calc_S2_Cret00BPTCTRBNS2F23"
    when
  $Cret00BPTCTRBNS2F12:TaxField(fieldName == "Cret00BPTCTRBNS2F12");
  $Cret00BPTCTRBNS2F14:TaxField(fieldName == "Cret00BPTCTRBNS2F14",calValue==null);
  $Cret00BPTCTRBNS2F15:TaxField(fieldName == "Cret00BPTCTRBNS2F15",calValue==null);
  $Cret00BPTCTRBNS2F17:TaxField(fieldName == "Cret00BPTCTRBNS2F17",calValue==null);
  $Cret00BPTCTRBNS2F18:TaxField(fieldName == "Cret00BPTCTRBNS2F18",calValue==null);
  $Cret00BPTCTRBNS2F19:TaxField(fieldName == "Cret00BPTCTRBNS2F19",calValue==null);
  $Cret00BPTCTRBNS2F20:TaxField(fieldName == "Cret00BPTCTRBNS2F20",calValue==null);
  $Cret00BPTCTRBNS2F21:TaxField(fieldName == "Cret00BPTCTRBNS2F21",calValue==null);
  $Cret00BPTCTRBNS2F22:TaxField(fieldName == "Cret00BPTCTRBNS2F22",calValue==null);
  $Cret00BPTCTRBNS2F23:TaxField(fieldName == "Cret00BPTCTRBNS2F23",calValue==null);
  
  $Cret00BPTCTRBNS11F10:TaxField(fieldName == "Cret00BPTCTRBNS11F10");
  $Cret00BPTCTRBNS11F22:TaxField(fieldName == "Cret00BPTCTRBNS11F22");
  $Cret00BPTCTRBNS11F31:TaxField(fieldName == "Cret00BPTCTRBNS11F31");
    then
  //S2F14: Should be equal as S11F22, if not, S11F22 prevails
  String s11f22 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS11F22);
  //if(!s11f22.equals($Cret00BPTCTRBNS2F14.getNeedValue())) {
    //$Cret00BPTCTRBNS2F14.setCalValue(s11f22);
   // assResult.compareAndSet($Cret00BPTCTRBNS2F14);
    //update($Cret00BPTCTRBNS2F14);
  //}

  //S2F15: Should be equal as S11F31, if not, S11F31 prevails
  String s11f31 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS11F31);
  //if(!s11f31.equals($Cret00BPTCTRBNS2F15.getNeedValue())) {
  //  $Cret00BPTCTRBNS2F15.setCalValue(s11f31);
   // assResult.compareAndSet($Cret00BPTCTRBNS2F15);
    //update($Cret00BPTCTRBNS2F15);
  //}
  
  //S2F19: Should be equal as S11F10, if not, S11F10 prevails
  String s11f10 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS11F10);
  //if(!s11f10.equals($Cret00BPTCTRBNS2F19.getNeedValue())) {
  //  $Cret00BPTCTRBNS2F19.setCalValue(s11f10);
  //  assResult.compareAndSet($Cret00BPTCTRBNS2F19);
    //update($Cret00BPTCTRBNS2F19);
  //}

  // V1 = =S2F12+S2F14+S2F15+S2F17
  String v1 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F12, $Cret00BPTCTRBNS2F14, $Cret00BPTCTRBNS2F15,
    $Cret00BPTCTRBNS2F17);

  // V2 = S2F18+S2F19+S2F20+S2F21+S2F22
  String v2 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F18, $Cret00BPTCTRBNS2F19, $Cret00BPTCTRBNS2F20,
    $Cret00BPTCTRBNS2F21, $Cret00BPTCTRBNS2F22);

  // S2F23 = V1 - V2
  $Cret00BPTCTRBNS2F23.setCalValue(TaxMathUtils.sub(v1, v2));
  assResult.compareAndSet($Cret00BPTCTRBNS2F23);
  //update($Cret00BPTCTRBNS2F23);
end
//----------Schedule 2: end-------------------------

//----------Schedule 3: start-------------------------
//Schedule 3 : Tax return for Commercial Business [1: S3F1:Should be equal as S2F23, if not, S2F23 prevails]
rule "calc_S3_Cret00BPTCTRBNS3F1"
    when
  $Cret00BPTCTRBNS3F1:TaxField(fieldName == "Cret00BPTCTRBNS3F1",calValue==null);
  $Cret00BPTCTRBNS2F23:TaxField(fieldName == "Cret00BPTCTRBNS2F23");
    then
  $Cret00BPTCTRBNS3F1.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F23));
  assResult.compareAndSet($Cret00BPTCTRBNS3F1);
  //update($Cret00BPTCTRBNS3F1);
end



//Schedule 3 : Tax return for Commercial Business (A) [3: S3F18=S3F2+S3F3..+S3F17]
rule "calc_S3_Cret00BPTCTRBNS3F18"
    when
  $Cret00BPTCTRBNS3F2:TaxField(fieldName == "Cret00BPTCTRBNS3F2");
  $Cret00BPTCTRBNS3F3:TaxField(fieldName == "Cret00BPTCTRBNS3F3");
  $Cret00BPTCTRBNS3F4:TaxField(fieldName == "Cret00BPTCTRBNS3F4");
  $Cret00BPTCTRBNS3F38:TaxField(fieldName == "Cret00BPTCTRBNS3F38");
  $Cret00BPTCTRBNS3F5:TaxField(fieldName == "Cret00BPTCTRBNS3F5");
  $Cret00BPTCTRBNS3F6:TaxField(fieldName == "Cret00BPTCTRBNS3F6");
  $Cret00BPTCTRBNS3F7:TaxField(fieldName == "Cret00BPTCTRBNS3F7");
  $Cret00BPTCTRBNS3F8:TaxField(fieldName == "Cret00BPTCTRBNS3F8");
        $Cret00BPTCTRBNS3F9:TaxField(fieldName == "Cret00BPTCTRBNS3F9");
  $Cret00BPTCTRBNS3F10:TaxField(fieldName == "Cret00BPTCTRBNS3F10");
  $Cret00BPTCTRBNS3F11:TaxField(fieldName == "Cret00BPTCTRBNS3F11");
  $Cret00BPTCTRBNS3F12:TaxField(fieldName == "Cret00BPTCTRBNS3F12");
  $Cret00BPTCTRBNS3F13:TaxField(fieldName == "Cret00BPTCTRBNS3F13");
  $Cret00BPTCTRBNS3F14:TaxField(fieldName == "Cret00BPTCTRBNS3F14");
  $Cret00BPTCTRBNS3F15:TaxField(fieldName == "Cret00BPTCTRBNS3F15");
  $Cret00BPTCTRBNS3F16:TaxField(fieldName == "Cret00BPTCTRBNS3F16");
  $Cret00BPTCTRBNS3F38A:TaxField(fieldName == "Cret00BPTCTRBNS3F38A");
  $Cret00BPTCTRBNS3F18:TaxField(fieldName == "Cret00BPTCTRBNS3F18",calValue==null);
    then
  $Cret00BPTCTRBNS3F18.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F2, $Cret00BPTCTRBNS3F3, $Cret00BPTCTRBNS3F4,
    $Cret00BPTCTRBNS3F38, $Cret00BPTCTRBNS3F5, $Cret00BPTCTRBNS3F6, $Cret00BPTCTRBNS3F7, $Cret00BPTCTRBNS3F8, 
    $Cret00BPTCTRBNS3F9, $Cret00BPTCTRBNS3F10, $Cret00BPTCTRBNS3F11, $Cret00BPTCTRBNS3F12, $Cret00BPTCTRBNS3F13, 
    $Cret00BPTCTRBNS3F14, $Cret00BPTCTRBNS3F15, $Cret00BPTCTRBNS3F16,$Cret00BPTCTRBNS3F38A));  
   assResult.compareAndSet($Cret00BPTCTRBNS3F18);
  //update($Cret00BPTCTRBNS3F18);  
end

//Schedule 3 : Tax return for Commercial Business [4: S3F19=S3F1+S3F18]
rule "calc_S3_Cret00BPTCTRBNS3F19"
    when
  $Cret00BPTCTRBNS3F1:TaxField(fieldName == "Cret00BPTCTRBNS3F1");
  $Cret00BPTCTRBNS3F18:TaxField(fieldName == "Cret00BPTCTRBNS3F18");
  $Cret00BPTCTRBNS3F19:TaxField(fieldName == "Cret00BPTCTRBNS3F19",calValue==null);
    then
  $Cret00BPTCTRBNS3F19.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F1, $Cret00BPTCTRBNS3F18));  
  assResult.compareAndSet($Cret00BPTCTRBNS3F19);
  //update($Cret00BPTCTRBNS3F19);  
end

//Schedule 3 : Tax return for Commercial Business [5: S3F20: Should be equal as S8F16, if not, S8F16 prevails]
rule "calc_S3_Cret00BPTCTRBNS3F20"
    when
  $Cret00BPTCTRBNS3F20:TaxField(fieldName == "Cret00BPTCTRBNS3F20",calValue==null);
  $Cret00BPTCTRBNS8F16:TaxField(fieldName == "Cret00BPTCTRBNS8F16");
    then
  $Cret00BPTCTRBNS3F20.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F16));
  assResult.compareAndSet($Cret00BPTCTRBNS3F20);
  //update($Cret00BPTCTRBNS3F20);
end

//Schedule 3 : Tax return for Commercial Business [6: S3F21: This value should not exceeds S3F12, otherwise, system will limit this value to S3F12]
rule "calc_S3_Cret00BPTCTRBNS3F21"
    when
  $Cret00BPTCTRBNS3F21:TaxField(fieldName == "Cret00BPTCTRBNS3F21",calValue==null);
  $Cret00BPTCTRBNS3F12:TaxField(fieldName == "Cret00BPTCTRBNS3F12");
    then
  String s3f21 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F21);
  String s3f12 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F12);
  if(TaxMathUtils.compareTo(s3f21, s3f12) > 0) {
    s3f21 = s3f12;
  }
  $Cret00BPTCTRBNS3F21.setCalValue(s3f21);
  assResult.compareAndSet($Cret00BPTCTRBNS3F21);
  //update($Cret00BPTCTRBNS3F21);
end

//Schedule 3 : Tax return for Commercial Business [8]
rule "calc_S3_Cret00BPTCTRBNS3F25"
    when
  $Cret00BPTCTRBNS2F23:TaxField(fieldName == "Cret00BPTCTRBNS2F23");
  $Cret00BPTCTRBNS3F2:TaxField(fieldName == "Cret00BPTCTRBNS3F2");
  $Cret00BPTCTRBNS3F3:TaxField(fieldName == "Cret00BPTCTRBNS3F3");
  $Cret00BPTCTRBNS3F4:TaxField(fieldName == "Cret00BPTCTRBNS3F4");
  $Cret00BPTCTRBNS3F25:TaxField(fieldName == "Cret00BPTCTRBNS3F25",calValue==null);

  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  //S3F25=S3F2
  // (+) S3F4 or S2F23*10%
  // (System will take the smaller value, and if S2F23 is negative value, set this value be 0)
  // (+) 25%*S3F3
  // (+) 25%*S3F3 in previous year, if S3F3 has been declared in previous year

  String smallV = null;
  String s2f23 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS2F23);
  if(TaxMathUtils.compareTo(s2f23, "0") < 0) {
    smallV = TaxMathUtils.sum("0");
  }else {
    String s3f4 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F4);
    String m10_S2f23 = TaxMathUtils.mulitplyTax(s2f23, "0.1");
    if(TaxMathUtils.compareTo(s3f4, m10_S2f23) > 0) {
      smallV = m10_S2f23;
    }else {
      smallV = s3f4;
    }
  }
  String m25_S3f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS3F3.getNeedValue(), "0.25");
  String pvS3f3 = TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS3F3");
  String p_m25_S3f3 = TaxMathUtils.mulitplyTax(pvS3f3, "0.25");
  
  $Cret00BPTCTRBNS3F25.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS3F2.getNeedValue(), smallV, m25_S3f3, p_m25_S3f3));
  assResult.compareAndSet($Cret00BPTCTRBNS3F25);
  //update($Cret00BPTCTRBNS3F25);
end

//Schedule 3 : Tax return for Commercial Business [8: S3F26: This value should not exceeds S2F15, otherwise, system will limit this value to S2F15]
rule "calc_S3_Cret00BPTCTRBNS3F26"
    when
  $Cret00BPTCTRBNS3F26:TaxField(fieldName == "Cret00BPTCTRBNS3F26",calValue==null);
  $Cret00BPTCTRBNS2F15:TaxField(fieldName == "Cret00BPTCTRBNS2F15");
    then
  String S3f26 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F26);
  String s2f15 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F15);
  if(TaxMathUtils.compareTo(S3f26, s2f15) > 0) {
    S3f26 = s2f15;
  }
  $Cret00BPTCTRBNS3F26.setCalValue(S3f26);
  assResult.compareAndSet($Cret00BPTCTRBNS3F26);
  //update($Cret00BPTCTRBNS3F26);
end

//Schedule 3 : Tax return for Commercial Business [9: S3F28=S3F20+S3F21+S3F22+S3F25+S3F26]
rule "calc_S3_Cret00BPTCTRBNS3F28"
    when
  $Cret00BPTCTRBNS3F20:TaxField(fieldName == "Cret00BPTCTRBNS3F20");
  $Cret00BPTCTRBNS3F21:TaxField(fieldName == "Cret00BPTCTRBNS3F21");
  $Cret00BPTCTRBNS3F22:TaxField(fieldName == "Cret00BPTCTRBNS3F22");
  $Cret00BPTCTRBNS3F25:TaxField(fieldName == "Cret00BPTCTRBNS3F25");
  $Cret00BPTCTRBNS3F26:TaxField(fieldName == "Cret00BPTCTRBNS3F26");
  $Cret00BPTCTRBNS3F39:TaxField(fieldName == "Cret00BPTCTRBNS3F39");
  $Cret00BPTCTRBNS3F28:TaxField(fieldName == "Cret00BPTCTRBNS3F28",calValue==null);
    then
  $Cret00BPTCTRBNS3F28.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F20, $Cret00BPTCTRBNS3F21, 
    $Cret00BPTCTRBNS3F22, $Cret00BPTCTRBNS3F25, $Cret00BPTCTRBNS3F26, $Cret00BPTCTRBNS3F39));  
  assResult.compareAndSet($Cret00BPTCTRBNS3F28);
  //update($Cret00BPTCTRBNS3F28);  
end

//Schedule 3 : Tax return for Commercial Business [9]
rule "calc_S3_Cret00BPTCTRBNS3F37"
    when
  $Cret00BPTCTRBNS3F3:TaxField(fieldName == "Cret00BPTCTRBNS3F3");
  $Cret00BPTCTRBNS3F19:TaxField(fieldName == "Cret00BPTCTRBNS3F19");
  $Cret00BPTCTRBNS3F28:TaxField(fieldName == "Cret00BPTCTRBNS3F28");
  $Cret00BPTCTRBNS3F37:TaxField(fieldName == "Cret00BPTCTRBNS3F37",calValue==null);
    then
  String s3f19 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS3F19);
  String s3f37 = TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS3F19, $Cret00BPTCTRBNS3F28);  
  if(TaxMathUtils.compareTo(s3f19, "0") > 0 && TaxMathUtils.compareTo(s3f37, "0") <= 0) {
    String m25_s3f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS3F3, 0.25);
    String m50_s3f28 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS3F28, 0.5);
    if(TaxMathUtils.compareTo(m25_s3f3, m50_s3f28) > 0) {
      s3f37 = TaxMathUtils.sum("0");
    }
  }
  $Cret00BPTCTRBNS3F37.setCalValue(s3f37);
  assResult.compareAndSet($Cret00BPTCTRBNS3F37);
  //update($Cret00BPTCTRBNS3F37);  
end

////Schedule 3 : Tax return for Commercial Business [2: calc S3F27 and S3F17]
rule "calc_S3_Cret00BPTCTRBNS3F27_AND_S3F17"
    when
  $Cret00BPTCTRBNS3F17_HIDDEN:TaxField(fieldName == "Cret00BPTCTRBNS3F17_HIDDEN",calValue==null);
  $Cret00BPTCTRBNS3F27:TaxField(fieldName == "Cret00BPTCTRBNS3F27",calValue==null);
  $Cret00BPTCTRBNS3F37:TaxField(fieldName == "Cret00BPTCTRBNS3F37");
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  /*
  String zero = TaxMathUtils.sum("0");
  String s3f29_pvs = TaxMathUtils.sum(TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS3F29"));
    
  
    if(TaxMathUtils.compareTo(s3f29_pvs, zero) >= 0) {
    $Cret00BPTCTRBNS3F17_HIDDEN.setCalValue(zero);
    $Cret00BPTCTRBNS3F27.setCalValue(zero);
    }else {
    String abs_S3f29_pvs = TaxMathUtils.strAbs(s3f29_pvs);
    String s3f29_b6y = TaxMathUtils.sum(TaxValidation.getBeforeNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS3F29", Integer.valueOf(6)));
      
    if(TaxMathUtils.compareTo(s3f29_b6y, zero) >= 0) {
      $Cret00BPTCTRBNS3F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS3F27.setCalValue(abs_S3f29_pvs);
    }else {
      List s3f37List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS3F37", Integer.valueOf(5));  
      List s3f17List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS3F17_HIDDEN", Integer.valueOf(5));
      String fulfilledV = TaxMathUtils.sum(TaxMathUtils.sumListPositive(s3f37List), TaxMathUtils.sumListPositive(s3f17List));
      
      

      String abs_S3f29_b6y = TaxMathUtils.strAbs(s3f29_b6y);
      String noFulfilledv = TaxMathUtils.sub(fulfilledV, abs_S3f29_b6y);
      String abs_noFulfilledv = TaxMathUtils.strAbs(noFulfilledv);
         
      if(TaxMathUtils.compareTo(noFulfilledv, zero) >= 0) {
      $Cret00BPTCTRBNS3F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS3F27.setCalValue(abs_S3f29_pvs);
      }else {
      $Cret00BPTCTRBNS3F17_HIDDEN.setCalValue(abs_noFulfilledv);
      $Cret00BPTCTRBNS3F27.setCalValue(TaxMathUtils.sub(abs_S3f29_pvs, abs_noFulfilledv));
      }
    }
    }
  
  assResult.compareAndSet($Cret00BPTCTRBNS3F17_HIDDEN);
  //update($Cret00BPTCTRBNS3F17_HIDDEN);
*/
  String carriedForwardLoss = TaxValidation.getBptLossFromRestoreAndUpdateIsStatus($Cret00BPTRetVerUid.getNeedValue(),$Cret00BPTCTRBNS3F37.getNeedValue(),"Commercial");
  $Cret00BPTCTRBNS3F27.setCalValue(carriedForwardLoss);
  assResult.compareAndSet($Cret00BPTCTRBNS3F27);
  //update($Cret00BPTCTRBNS3F27);
end

//Schedule 3 : Tax return for Commercial Business [10: S3F29=S3F37-S3F27]
rule "calc_S3_Cret00BPTCTRBNS3F29"
    when
  $Cret00BPTCTRBNS3F37:TaxField(fieldName == "Cret00BPTCTRBNS3F37");
  $Cret00BPTCTRBNS3F27:TaxField(fieldName == "Cret00BPTCTRBNS3F27");
  $Cret00BPTCTRBNS3F29:TaxField(fieldName == "Cret00BPTCTRBNS3F29",calValue==null);
    then
  $Cret00BPTCTRBNS3F29.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS3F37, $Cret00BPTCTRBNS3F27));  
  assResult.compareAndSet($Cret00BPTCTRBNS3F29);
  //update($Cret00BPTCTRBNS3F29);  
end

//Schedule 3 : Tax return for Commercial Business [11: S3F30: if S9F9 is positive, this value should be equal as S9F9 and S9F9 prevails when discrepancy, otherwise, leave it blank]
rule "calc_S3_Cret00BPTCTRBNS3F30"
    when
  $Cret00BPTCTRBNS3F30:TaxField(fieldName == "Cret00BPTCTRBNS3F30",calValue==null);
  $Cret00BPTCTRBNS9F9:TaxField(fieldName == "Cret00BPTCTRBNS9F9");
    then
  String s3f30 = String.valueOf(0);
  String s9f9 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS9F9);
  if(TaxMathUtils.compareTo(s9f9, String.valueOf(0)) > 0) {
    s3f30 = s9f9;
  }
  $Cret00BPTCTRBNS3F30.setCalValue(s3f30);
  assResult.compareAndSet($Cret00BPTCTRBNS3F30);
  //update($Cret00BPTCTRBNS3F30);
end

//Schedule 3 : Tax return for Commercial Business [12: S3F31=S2F14-S2F19]
rule "calc_S3_Cret00BPTCTRBNS3F31"
    when
  $Cret00BPTCTRBNS2F14:TaxField(fieldName == "Cret00BPTCTRBNS2F14");
  $Cret00BPTCTRBNS2F19:TaxField(fieldName == "Cret00BPTCTRBNS2F19");
  $Cret00BPTCTRBNS3F31:TaxField(fieldName == "Cret00BPTCTRBNS3F31",calValue==null);
    then
  $Cret00BPTCTRBNS3F31.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS2F14, $Cret00BPTCTRBNS2F19));  
  assResult.compareAndSet($Cret00BPTCTRBNS3F31);
  //update($Cret00BPTCTRBNS3F31);  
end

//Schedule 3 : Tax return for Commercial Business [13: S3F36=S3F29-(S3F30+S3F31+S3F32+S3F33+S3F34+S3F35) ]
rule "calc_S3_Cret00BPTCTRBNS3F36"
    when
  $Cret00BPTCTRBNS3F29:TaxField(fieldName == "Cret00BPTCTRBNS3F29");
  $Cret00BPTCTRBNS3F30:TaxField(fieldName == "Cret00BPTCTRBNS3F30");
  $Cret00BPTCTRBNS3F31:TaxField(fieldName == "Cret00BPTCTRBNS3F31");
  $Cret00BPTCTRBNS3F32:TaxField(fieldName == "Cret00BPTCTRBNS3F32");
  $Cret00BPTCTRBNS3F33:TaxField(fieldName == "Cret00BPTCTRBNS3F33");
  $Cret00BPTCTRBNS3F34:TaxField(fieldName == "Cret00BPTCTRBNS3F34");
  $Cret00BPTCTRBNS3F35:TaxField(fieldName == "Cret00BPTCTRBNS3F35");
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36",calValue==null);
    then
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F30, $Cret00BPTCTRBNS3F31, $Cret00BPTCTRBNS3F32, 
    $Cret00BPTCTRBNS3F33, $Cret00BPTCTRBNS3F34, $Cret00BPTCTRBNS3F35);
  $Cret00BPTCTRBNS3F36.setCalValue(TaxMathUtils.sub($Cret00BPTCTRBNS3F29.getNeedValue(), sumV));  
  assResult.compareAndSet($Cret00BPTCTRBNS3F36);
  //update($Cret00BPTCTRBNS3F36);  
end
//----------Schedule 3: end--------------------------

//----------Schedule 4: start-----------------------
//Schedule 4 : Income Statement for Industrial Business (B)
rule "calc_S4_Cret00BPTCTRBNS4F4"
    when
  $Cret00BPTCTRBNS4F1:TaxField(fieldName == "Cret00BPTCTRBNS4F1");
  $Cret00BPTCTRBNS4F3:TaxField(fieldName == "Cret00BPTCTRBNS4F3");
  $Cret00BPTCTRBNS4F4:TaxField(fieldName == "Cret00BPTCTRBNS4F4",calValue==null);
    then
  //S4F4=s4f1-s4f3
  $Cret00BPTCTRBNS4F4.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS4F1, $Cret00BPTCTRBNS4F3));
  assResult.compareAndSet($Cret00BPTCTRBNS4F4);
end

//Schedule 4 : Income Statement for Industrial Business (B)
rule "calc_S4_Cret00BPTCTRBNS4F9"
    when
  $Cret00BPTCTRBNS4F5:TaxField(fieldName == "Cret00BPTCTRBNS4F5");
  $Cret00BPTCTRBNS4F6:TaxField(fieldName == "Cret00BPTCTRBNS4F6");
  $Cret00BPTCTRBNS4F7:TaxField(fieldName == "Cret00BPTCTRBNS4F7");
  $Cret00BPTCTRBNS4F8:TaxField(fieldName == "Cret00BPTCTRBNS4F8");
  $Cret00BPTCTRBNS4F9:TaxField(fieldName == "Cret00BPTCTRBNS4F9",calValue==null);
    then
  //S4F9=S4F5+S4F6+S4F7-S4F8
  $Cret00BPTCTRBNS4F9.setCalValue(TaxMathUtils.calTaxOriginal(new OperatorWrapper($Cret00BPTCTRBNS4F5),new OperatorWrapper($Cret00BPTCTRBNS4F6,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F7,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F8,"-")));
  assResult.compareAndSet($Cret00BPTCTRBNS4F9);
end

//Schedule 4 : Income Statement for Industrial Business (B)
rule "calc_s4_Cret00BPTCTRBNS4F15"
    when
  $Cret00BPTCTRBNS4F9:TaxField(fieldName == "Cret00BPTCTRBNS4F9");
  $Cret00BPTCTRBNS4F10:TaxField(fieldName == "Cret00BPTCTRBNS4F10");
  $Cret00BPTCTRBNS4F11:TaxField(fieldName == "Cret00BPTCTRBNS4F11");
  $Cret00BPTCTRBNS4F12:TaxField(fieldName == "Cret00BPTCTRBNS4F12");
  $Cret00BPTCTRBNS4F13:TaxField(fieldName == "Cret00BPTCTRBNS4F13");
  $Cret00BPTCTRBNS4F14:TaxField(fieldName == "Cret00BPTCTRBNS4F14");
  $Cret00BPTCTRBNS4F15:TaxField(fieldName == "Cret00BPTCTRBNS4F15",calValue==null);
    then
  //S4F15=S4F9+S4F10+S4F11+S4F12+S4F13+S4F14
  $Cret00BPTCTRBNS4F15.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS4F9,$Cret00BPTCTRBNS4F10,$Cret00BPTCTRBNS4F11,
    $Cret00BPTCTRBNS4F12,$Cret00BPTCTRBNS4F13,$Cret00BPTCTRBNS4F14));
  assResult.compareAndSet($Cret00BPTCTRBNS4F15);
end

//Schedule 4 : Income Statement for Industrial Business (B)
rule "calc_S4_Cret00BPTCTRBNS4F18"
    when
  $Cret00BPTCTRBNS4F15:TaxField(fieldName == "Cret00BPTCTRBNS4F15");
  $Cret00BPTCTRBNS4F16:TaxField(fieldName == "Cret00BPTCTRBNS4F16");
  $Cret00BPTCTRBNS4F17:TaxField(fieldName == "Cret00BPTCTRBNS4F17"); 
  $Cret00BPTCTRBNS4F18:TaxField(fieldName == "Cret00BPTCTRBNS4F18",calValue==null);
    then
  //S4F18=S4F15+S4F16-S4F17
  $Cret00BPTCTRBNS4F18.setCalValue(TaxMathUtils.calTaxOriginal(new OperatorWrapper($Cret00BPTCTRBNS4F15),new OperatorWrapper($Cret00BPTCTRBNS4F16,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F17,"-")));
  assResult.compareAndSet($Cret00BPTCTRBNS4F18);
end

//Schedule 4 : Income Statement for Industrial Business (B)[S4F22: Cost of Sales]
rule "calc_S4_Cret00BPTCTRBNS4F22"
    when
  $Cret00BPTCTRBNS4F18:TaxField(fieldName == "Cret00BPTCTRBNS4F18");
  $Cret00BPTCTRBNS4F19:TaxField(fieldName == "Cret00BPTCTRBNS4F19");
  $Cret00BPTCTRBNS4F20:TaxField(fieldName == "Cret00BPTCTRBNS4F20");
  $Cret00BPTCTRBNS4F21:TaxField(fieldName == "Cret00BPTCTRBNS4F21"); 
  $Cret00BPTCTRBNS4F22:TaxField(fieldName == "Cret00BPTCTRBNS4F22",calValue==null);
    then
  //S4F22=S4F18+S4F19+S4F20-S4F21
  $Cret00BPTCTRBNS4F22.setCalValue(TaxMathUtils.calTaxOriginal(new OperatorWrapper($Cret00BPTCTRBNS4F18),new OperatorWrapper($Cret00BPTCTRBNS4F19,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F20,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F21,"-")));
  assResult.compareAndSet($Cret00BPTCTRBNS4F22);
end

//Schedule 4 : Income Statement for Industrial Business (B)[S4F23: Gross profits (Net sales-Cost of sales)]
rule "calc_S4_Cret00BPTCTRBNS4F23"
    when
  $Cret00BPTCTRBNS4F4:TaxField(fieldName == "Cret00BPTCTRBNS4F4");
  $Cret00BPTCTRBNS4F22:TaxField(fieldName == "Cret00BPTCTRBNS4F22");
  $Cret00BPTCTRBNS4F23:TaxField(fieldName == "Cret00BPTCTRBNS4F23",calValue==null);
    then
  //s4f23=s4f4-s4f22
  $Cret00BPTCTRBNS4F23.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS4F4,$Cret00BPTCTRBNS4F22));
  assResult.compareAndSet($Cret00BPTCTRBNS4F23);
end

//Schedule 4 : Income Statement for Industrial Business (B)[S4F24=S4F23/S4F22 (Percentage)]
rule "calc_S4_Cret00BPTCTRBNS4F24"
    when   
  $Cret00BPTCTRBNS4F22:TaxField(fieldName == "Cret00BPTCTRBNS4F22");
  $Cret00BPTCTRBNS4F23:TaxField(fieldName == "Cret00BPTCTRBNS4F23");
  $Cret00BPTCTRBNS4F24:TaxField(fieldName == "Cret00BPTCTRBNS4F24",calValue==null);
    then
  //S4F24=S4F23/S4F22 (Percentage)
  String m100v = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS4F23.getNeedValue(), "100");
  $Cret00BPTCTRBNS4F24.setCalValue(TaxMathUtils.division(m100v, $Cret00BPTCTRBNS4F22.getNeedValue()));
  assResult.compareAndSet($Cret00BPTCTRBNS4F24);
end

//Schedule 4 : Income Statement for Industrial Business (B)
rule "calc_S4_Cret00BPTCTRBNS4F34"
    when
  $Cret00BPTCTRBNS4F23:TaxField(fieldName == "Cret00BPTCTRBNS4F23");
  $Cret00BPTCTRBNS4F25:TaxField(fieldName == "Cret00BPTCTRBNS4F25");
  $Cret00BPTCTRBNS4F26:TaxField(fieldName == "Cret00BPTCTRBNS4F26");
  $Cret00BPTCTRBNS4F28:TaxField(fieldName == "Cret00BPTCTRBNS4F28");
  $Cret00BPTCTRBNS4F29:TaxField(fieldName == "Cret00BPTCTRBNS4F29");
  $Cret00BPTCTRBNS4F30:TaxField(fieldName == "Cret00BPTCTRBNS4F30");
  $Cret00BPTCTRBNS4F31:TaxField(fieldName == "Cret00BPTCTRBNS4F31");
  $Cret00BPTCTRBNS4F32:TaxField(fieldName == "Cret00BPTCTRBNS4F32");
  $Cret00BPTCTRBNS4F33:TaxField(fieldName == "Cret00BPTCTRBNS4F33");
  $Cret00BPTCTRBNS4F34:TaxField(fieldName == "Cret00BPTCTRBNS4F34",calValue==null);

  $Cret00BPTCTRBNS11F23:TaxField(fieldName == "Cret00BPTCTRBNS11F23");
  $Cret00BPTCTRBNS11F32:TaxField(fieldName == "Cret00BPTCTRBNS11F32");
  $Cret00BPTCTRBNS11F11:TaxField(fieldName == "Cret00BPTCTRBNS11F11");
    then
  //S4F25: Should be equal as S11F23, if not, S11F23 prevails
  //$Cret00BPTCTRBNS4F25.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F23.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS4F25);

  //S4F26: Should be equal as S11F32, if not, S11F32 prevails
  //$Cret00BPTCTRBNS4F26.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F32.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS4F26);

  //S4F30: Should be equal as S11F11, if not, S11F11 prevails
  //$Cret00BPTCTRBNS4F30.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F11.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS4F30);

  //S4F34=S4F23+S4F25+S4F26+S4F28-S4F29-S4F30-S4F31-S4F32-S4F33
  $Cret00BPTCTRBNS4F34.setCalValue(TaxMathUtils.calTaxOriginal(new OperatorWrapper($Cret00BPTCTRBNS4F23),new OperatorWrapper($Cret00BPTCTRBNS4F25,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F26,"+"),
    new OperatorWrapper($Cret00BPTCTRBNS4F28,"+"),new OperatorWrapper($Cret00BPTCTRBNS4F29,"-"),new OperatorWrapper($Cret00BPTCTRBNS4F30,"-"),
    new OperatorWrapper($Cret00BPTCTRBNS4F31,"-"),new OperatorWrapper($Cret00BPTCTRBNS4F32,"-"),new OperatorWrapper($Cret00BPTCTRBNS4F33,"-")));
  assResult.compareAndSet($Cret00BPTCTRBNS4F34);
end
//----------Schedule 4: end----------------------------

//----------Schedule 5: start-------------------------
//Schedule 5 : Tax return for Industrial Business [1]
//S5F1:Should be equal as S4F34, if not, S4F34 prevails
rule "calc_S5_Cret00BPTCTRBNS5F1"
    when
  $Cret00BPTCTRBNS5F1:TaxField(fieldName == "Cret00BPTCTRBNS5F1",calValue==null);
  $Cret00BPTCTRBNS4F34:TaxField(fieldName == "Cret00BPTCTRBNS4F34");
    then
  $Cret00BPTCTRBNS5F1.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS4F34));
  assResult.compareAndSet($Cret00BPTCTRBNS5F1);
  //update($Cret00BPTCTRBNS5F1);
end



//Schedule 5 : Tax return for Industrial Business [3]
//S5F18=S5F2+S5F3..+S5F17
rule "calc_S5_Cret00BPTCTRBNS5F18"
    when
  $Cret00BPTCTRBNS5F2:TaxField(fieldName == "Cret00BPTCTRBNS5F2");
  $Cret00BPTCTRBNS5F3:TaxField(fieldName == "Cret00BPTCTRBNS5F3");
  $Cret00BPTCTRBNS5F4:TaxField(fieldName == "Cret00BPTCTRBNS5F4");
  $Cret00BPTCTRBNS5F38:TaxField(fieldName == "Cret00BPTCTRBNS5F38");
  $Cret00BPTCTRBNS5F5:TaxField(fieldName == "Cret00BPTCTRBNS5F5");
  $Cret00BPTCTRBNS5F6:TaxField(fieldName == "Cret00BPTCTRBNS5F6");
  $Cret00BPTCTRBNS5F7:TaxField(fieldName == "Cret00BPTCTRBNS5F7");
  $Cret00BPTCTRBNS5F8:TaxField(fieldName == "Cret00BPTCTRBNS5F8");
        $Cret00BPTCTRBNS5F9:TaxField(fieldName == "Cret00BPTCTRBNS5F9");
  $Cret00BPTCTRBNS5F10:TaxField(fieldName == "Cret00BPTCTRBNS5F10");
  $Cret00BPTCTRBNS5F11:TaxField(fieldName == "Cret00BPTCTRBNS5F11");
  $Cret00BPTCTRBNS5F12:TaxField(fieldName == "Cret00BPTCTRBNS5F12");
  $Cret00BPTCTRBNS5F13:TaxField(fieldName == "Cret00BPTCTRBNS5F13");
  $Cret00BPTCTRBNS5F14:TaxField(fieldName == "Cret00BPTCTRBNS5F14");
  $Cret00BPTCTRBNS5F15:TaxField(fieldName == "Cret00BPTCTRBNS5F15");
  $Cret00BPTCTRBNS5F16:TaxField(fieldName == "Cret00BPTCTRBNS5F16");
  $Cret00BPTCTRBNS5F38A:TaxField(fieldName == "Cret00BPTCTRBNS5F38A");
  $Cret00BPTCTRBNS5F18:TaxField(fieldName == "Cret00BPTCTRBNS5F18",calValue==null);
    then
  $Cret00BPTCTRBNS5F18.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F2, $Cret00BPTCTRBNS5F3, $Cret00BPTCTRBNS5F4,
    $Cret00BPTCTRBNS5F38, $Cret00BPTCTRBNS5F5, $Cret00BPTCTRBNS5F6, $Cret00BPTCTRBNS5F7, $Cret00BPTCTRBNS5F8, 
    $Cret00BPTCTRBNS5F9, $Cret00BPTCTRBNS5F10, $Cret00BPTCTRBNS5F11, $Cret00BPTCTRBNS5F12, $Cret00BPTCTRBNS5F13, 
    $Cret00BPTCTRBNS5F14, $Cret00BPTCTRBNS5F15, $Cret00BPTCTRBNS5F16,$Cret00BPTCTRBNS5F38A));  
   assResult.compareAndSet($Cret00BPTCTRBNS5F18);
  //update($Cret00BPTCTRBNS5F18);  
end

//Schedule 5 : Tax return for Industrial Business [4]
//S5F19=S5F1+S5F18
rule "calc_S5_Cret00BPTCTRBNS5F19"
    when
  $Cret00BPTCTRBNS5F1:TaxField(fieldName == "Cret00BPTCTRBNS5F1");
  $Cret00BPTCTRBNS5F18:TaxField(fieldName == "Cret00BPTCTRBNS5F18");
  $Cret00BPTCTRBNS5F19:TaxField(fieldName == "Cret00BPTCTRBNS5F19",calValue==null);
    then
  $Cret00BPTCTRBNS5F19.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F1, $Cret00BPTCTRBNS5F18));  
  assResult.compareAndSet($Cret00BPTCTRBNS5F19);
  //update($Cret00BPTCTRBNS5F19);  
end

//Schedule 5 : Tax return for Industrial Business [5]
//S5F20: Should be equal as S8F17, if not, S8F17 prevails
rule "calc_S5_Cret00BPTCTRBNS5F20"
    when
  $Cret00BPTCTRBNS5F20:TaxField(fieldName == "Cret00BPTCTRBNS5F20",calValue==null);
  $Cret00BPTCTRBNS8F17:TaxField(fieldName == "Cret00BPTCTRBNS8F17");
    then
  $Cret00BPTCTRBNS5F20.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F17));
  assResult.compareAndSet($Cret00BPTCTRBNS5F20);
  //update($Cret00BPTCTRBNS5F20);
end

//Schedule 5 : Tax return for Industrial Business [6]
//S5F21: This value should not exceeds S5F12, otherwise, system will limit this value to S5F12
rule "calc_S5_Cret00BPTCTRBNS5F21"
    when
  $Cret00BPTCTRBNS5F21:TaxField(fieldName == "Cret00BPTCTRBNS5F21",calValue==null);
  $Cret00BPTCTRBNS5F12:TaxField(fieldName == "Cret00BPTCTRBNS5F12");
    then
  String S5f21 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F21);
  String S5f12 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F12);
  if(TaxMathUtils.compareTo(S5f21, S5f12) > 0) {
    S5f21 = S5f12;
  }
  $Cret00BPTCTRBNS5F21.setCalValue(S5f21);
  assResult.compareAndSet($Cret00BPTCTRBNS5F21);
  //update($Cret00BPTCTRBNS5F21);
end

//Schedule 5 : Tax return for Industrial Business [7]
//S5F25=S5F2
// (+) S5F4 or S4F34*10%
// (System will take the smaller value, and if S4F34 is negative value, set this value be 0)
// (+) 25%*S5F3
// (+) 25%*S5F3 in previous year, if S5F3 has been declared in previous year
rule "calc_S5_Cret00BPTCTRBNS5F25"
    when
  $Cret00BPTCTRBNS4F34:TaxField(fieldName == "Cret00BPTCTRBNS4F34");
  $Cret00BPTCTRBNS5F2:TaxField(fieldName == "Cret00BPTCTRBNS5F2");
  $Cret00BPTCTRBNS5F3:TaxField(fieldName == "Cret00BPTCTRBNS5F3");
  $Cret00BPTCTRBNS5F4:TaxField(fieldName == "Cret00BPTCTRBNS5F4");
  $Cret00BPTCTRBNS5F25:TaxField(fieldName == "Cret00BPTCTRBNS5F25",calValue==null);

  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  String smallV = null;
  String s4f34 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS4F34);
  if(TaxMathUtils.compareTo(s4f34, "0") < 0) {
    smallV = TaxMathUtils.sum("0");
  }else {
    String S5f4 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F4);
    String m10_S4f34 = TaxMathUtils.mulitplyTax(s4f34, "0.1");
    if(TaxMathUtils.compareTo(S5f4, m10_S4f34) > 0) {
      smallV = m10_S4f34;
    }else {
      smallV = S5f4;
    }
  }
  String m25_S5f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS5F3.getNeedValue(), "0.25");
  String pvS5f3 = TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS5F3");
  String p_m25_S5f3 = TaxMathUtils.mulitplyTax(pvS5f3, "0.25");
  
  $Cret00BPTCTRBNS5F25.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS5F2.getNeedValue(), smallV, m25_S5f3, p_m25_S5f3));
  assResult.compareAndSet($Cret00BPTCTRBNS5F25);
  //update($Cret00BPTCTRBNS5F25);
end

//Schedule 5 : Tax return for Industrial Business [8]
//S5F26: This value should not exceeds S4F26, otherwise, system will limit this value to S4F26
rule "calc_S5_Cret00BPTCTRBNS5F26"
    when
  $Cret00BPTCTRBNS5F26:TaxField(fieldName == "Cret00BPTCTRBNS5F26",calValue==null);
  $Cret00BPTCTRBNS4F26:TaxField(fieldName == "Cret00BPTCTRBNS4F26");
    then
  String S5f26 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F26);
  String s4f26 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS4F26);
  if(TaxMathUtils.compareTo(S5f26, s4f26) > 0) {
    S5f26 = s4f26;
  }
  $Cret00BPTCTRBNS5F26.setCalValue(S5f26);
  assResult.compareAndSet($Cret00BPTCTRBNS5F26);
  //update($Cret00BPTCTRBNS5F26);
end

//Schedule 5 : Tax return for Industrial Business [9]
//S5F28=S5F20+S5F21+S5F22+S5F25+S5F26
rule "calc_S5_Cret00BPTCTRBNS5F28"
    when
  $Cret00BPTCTRBNS5F20:TaxField(fieldName == "Cret00BPTCTRBNS5F20");
  $Cret00BPTCTRBNS5F21:TaxField(fieldName == "Cret00BPTCTRBNS5F21");
  $Cret00BPTCTRBNS5F22:TaxField(fieldName == "Cret00BPTCTRBNS5F22");
  $Cret00BPTCTRBNS5F25:TaxField(fieldName == "Cret00BPTCTRBNS5F25");
  $Cret00BPTCTRBNS5F26:TaxField(fieldName == "Cret00BPTCTRBNS5F26");
  $Cret00BPTCTRBNS5F39:TaxField(fieldName == "Cret00BPTCTRBNS5F39");
  $Cret00BPTCTRBNS5F28:TaxField(fieldName == "Cret00BPTCTRBNS5F28",calValue==null);
    then
  $Cret00BPTCTRBNS5F28.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F20, $Cret00BPTCTRBNS5F21, 
    $Cret00BPTCTRBNS5F22, $Cret00BPTCTRBNS5F25, $Cret00BPTCTRBNS5F26,$Cret00BPTCTRBNS5F39));  
  assResult.compareAndSet($Cret00BPTCTRBNS5F28);
  //update($Cret00BPTCTRBNS5F28);  
end

//Schedule 5 : Tax return for Industrial Business [10]
rule "calc_S5_Cret00BPTCTRBNS5F37"
    when
  $Cret00BPTCTRBNS5F3:TaxField(fieldName == "Cret00BPTCTRBNS5F3");
  $Cret00BPTCTRBNS5F19:TaxField(fieldName == "Cret00BPTCTRBNS5F19");
  $Cret00BPTCTRBNS5F28:TaxField(fieldName == "Cret00BPTCTRBNS5F28");
  $Cret00BPTCTRBNS5F37:TaxField(fieldName == "Cret00BPTCTRBNS5F37",calValue==null);
    then
  String S5f19 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS5F19);
  String S5f37 = TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS5F19, $Cret00BPTCTRBNS5F28);  
  if(TaxMathUtils.compareTo(S5f19, "0") > 0 && TaxMathUtils.compareTo(S5f37, "0") <= 0) {
    String m25_S5f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS5F3, 0.25);
    String m50_S5f28 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS5F28, 0.5);
    if(TaxMathUtils.compareTo(m25_S5f3, m50_S5f28) > 0) {
      S5f37 = TaxMathUtils.sum("0");
    }
  }
  $Cret00BPTCTRBNS5F37.setCalValue(S5f37);
  assResult.compareAndSet($Cret00BPTCTRBNS5F37);
  //update($Cret00BPTCTRBNS5F37);  
end

//Schedule 5 : Tax return for Industrial Business [2]
//calc S5F27 and S5F17 by Validation Rule 
rule "calc_S5_Cret00BPTCTRBNS5F27_AND_S5F17"
    when
  $Cret00BPTCTRBNS5F17_HIDDEN:TaxField(fieldName == "Cret00BPTCTRBNS5F17_HIDDEN",calValue==null);
  $Cret00BPTCTRBNS5F27:TaxField(fieldName == "Cret00BPTCTRBNS5F27",calValue==null);
  $Cret00BPTCTRBNS5F37:TaxField(fieldName == "Cret00BPTCTRBNS5F37");
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  /*
  String zero = TaxMathUtils.sum("0");
  String S5f29_pvs = TaxMathUtils.sum(TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS5F29"));
    
  
    if(TaxMathUtils.compareTo(S5f29_pvs, zero) >= 0) {
    $Cret00BPTCTRBNS5F17_HIDDEN.setCalValue(zero);
    $Cret00BPTCTRBNS5F27.setCalValue(zero);
    }else {
    String abs_S5f29_pvs = TaxMathUtils.strAbs(S5f29_pvs);
    String S5f29_b6y = TaxMathUtils.sum(TaxValidation.getBeforeNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS5F29", Integer.valueOf(6)));
      
    if(TaxMathUtils.compareTo(S5f29_b6y, zero) >= 0) {
      $Cret00BPTCTRBNS5F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS5F27.setCalValue(abs_S5f29_pvs);
    }else {
      List S5f37List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS5F37", Integer.valueOf(5));  
      List S5f17List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS5F17_HIDDEN", Integer.valueOf(5));
      String fulfilledV = TaxMathUtils.sum(TaxMathUtils.sumListPositive(S5f37List), TaxMathUtils.sumListPositive(S5f17List));
        
      

      String abs_S5f29_b6y = TaxMathUtils.strAbs(S5f29_b6y);
      String noFulfilledv = TaxMathUtils.sub(fulfilledV, abs_S5f29_b6y);
      String abs_noFulfilledv = TaxMathUtils.strAbs(noFulfilledv);
         
      if(TaxMathUtils.compareTo(noFulfilledv, zero) >= 0) {
      $Cret00BPTCTRBNS5F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS5F27.setCalValue(abs_S5f29_pvs);
      }else {
      $Cret00BPTCTRBNS5F17_HIDDEN.setCalValue(abs_noFulfilledv);
      $Cret00BPTCTRBNS5F27.setCalValue(TaxMathUtils.sub(abs_S5f29_pvs, abs_noFulfilledv));
      }
    }
    }
  
  assResult.compareAndSet($Cret00BPTCTRBNS5F17_HIDDEN);
  //update($Cret00BPTCTRBNS5F17_HIDDEN);
*/
  String carriedForwardLoss = TaxValidation.getBptLossFromRestoreAndUpdateIsStatus($Cret00BPTRetVerUid.getNeedValue(),$Cret00BPTCTRBNS5F37.getNeedValue(),"Industrial");
  $Cret00BPTCTRBNS5F27.setCalValue(carriedForwardLoss);
    assResult.compareAndSet($Cret00BPTCTRBNS5F27);
  //update($Cret00BPTCTRBNS5F27);
end

//Schedule 5 : Tax return for Industrial Business [11]
//S5F29=S5F37-S5F27
rule "calc_S5_Cret00BPTCTRBNS5F29"
    when
  $Cret00BPTCTRBNS5F37:TaxField(fieldName == "Cret00BPTCTRBNS5F37");
  $Cret00BPTCTRBNS5F27:TaxField(fieldName == "Cret00BPTCTRBNS5F27");
  $Cret00BPTCTRBNS5F29:TaxField(fieldName == "Cret00BPTCTRBNS5F29",calValue==null);
    then
  $Cret00BPTCTRBNS5F29.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS5F37, $Cret00BPTCTRBNS5F27));  
  assResult.compareAndSet($Cret00BPTCTRBNS5F29);
  //update($Cret00BPTCTRBNS5F29);  
end

//Schedule 5 : Tax return for Industrial Business [12]
//S5F30: if S9F10 is positive, this value should be equal as S9F10 and S9F10 prevails when discrepancy, otherwise, leave it blank
rule "calc_S5_Cret00BPTCTRBNS5F30"
    when
  $Cret00BPTCTRBNS5F30:TaxField(fieldName == "Cret00BPTCTRBNS5F30",calValue==null);
  $Cret00BPTCTRBNS9F10:TaxField(fieldName == "Cret00BPTCTRBNS9F10");
    then
  String S5f30 = String.valueOf(0);
  String s9f10 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS9F10);
  if(TaxMathUtils.compareTo(s9f10, String.valueOf(0)) > 0) {
    S5f30 = s9f10;
  }
  $Cret00BPTCTRBNS5F30.setCalValue(S5f30);
  assResult.compareAndSet($Cret00BPTCTRBNS5F30);
  //update($Cret00BPTCTRBNS5F30);
end

//Schedule 5 : Tax return for Industrial Business [13]
//S5F31=S4F25-S4F30
rule "calc_S5_Cret00BPTCTRBNS5F31"
    when
  $Cret00BPTCTRBNS4F25:TaxField(fieldName == "Cret00BPTCTRBNS4F25");
  $Cret00BPTCTRBNS4F30:TaxField(fieldName == "Cret00BPTCTRBNS4F30");
  $Cret00BPTCTRBNS5F31:TaxField(fieldName == "Cret00BPTCTRBNS5F31",calValue==null);
    then
  $Cret00BPTCTRBNS5F31.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS4F25, $Cret00BPTCTRBNS4F30));  
  assResult.compareAndSet($Cret00BPTCTRBNS5F31);
  //update($Cret00BPTCTRBNS5F31);  
end

//Schedule 5 : Tax return for Industrial Business [14]
//S5F36=S5F29-(S5F30+S5F31+S5F32+S5F33+S5F34+S5F35) 
rule "calc_S5_Cret00BPTCTRBNS5F36"
    when
  $Cret00BPTCTRBNS5F29:TaxField(fieldName == "Cret00BPTCTRBNS5F29");
  $Cret00BPTCTRBNS5F30:TaxField(fieldName == "Cret00BPTCTRBNS5F30");
  $Cret00BPTCTRBNS5F31:TaxField(fieldName == "Cret00BPTCTRBNS5F31");
  $Cret00BPTCTRBNS5F32:TaxField(fieldName == "Cret00BPTCTRBNS5F32");
  $Cret00BPTCTRBNS5F33:TaxField(fieldName == "Cret00BPTCTRBNS5F33");
  $Cret00BPTCTRBNS5F34:TaxField(fieldName == "Cret00BPTCTRBNS5F34");
  $Cret00BPTCTRBNS5F35:TaxField(fieldName == "Cret00BPTCTRBNS5F35");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36",calValue==null);
    then
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F30, $Cret00BPTCTRBNS5F31, $Cret00BPTCTRBNS5F32, 
    $Cret00BPTCTRBNS5F33, $Cret00BPTCTRBNS5F34, $Cret00BPTCTRBNS5F35);
  $Cret00BPTCTRBNS5F36.setCalValue(TaxMathUtils.sub($Cret00BPTCTRBNS5F29.getNeedValue(), sumV));  
  assResult.compareAndSet($Cret00BPTCTRBNS5F36);
  //update($Cret00BPTCTRBNS5F36);  
end
//----------Schedule 5: end--------------------------

//----------Schedule 6: start-------------------------
//Schedule 6 : Income Statement for Services Business (C)
rule "calc_S6_Cret00BPTCTRBNS6F4_AND_5"
    when
  $Cret00BPTCTRBNS6F1:TaxField(fieldName == "Cret00BPTCTRBNS6F1");
  $Cret00BPTCTRBNS6F2:TaxField(fieldName == "Cret00BPTCTRBNS6F2");
  $Cret00BPTCTRBNS6F3:TaxField(fieldName == "Cret00BPTCTRBNS6F3");
  $Cret00BPTCTRBNS6F4:TaxField(fieldName == "Cret00BPTCTRBNS6F4",calValue==null);
  $Cret00BPTCTRBNS6F5:TaxField(fieldName == "Cret00BPTCTRBNS6F5",calValue==null);
    then
  //S6F4=S6F2+S6F3
  $Cret00BPTCTRBNS6F4.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS6F2,$Cret00BPTCTRBNS6F3));
  assResult.compareAndSet($Cret00BPTCTRBNS6F4);
    
  //S6F5=S6F1-S6F4
  $Cret00BPTCTRBNS6F5.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS6F1,$Cret00BPTCTRBNS6F4));
  assResult.compareAndSet($Cret00BPTCTRBNS6F5);
end

//Schedule 6 : Income Statement for Services Business (C)
rule "calc_S6_Cret00BPTCTRBNS6F15"
    when
  $Cret00BPTCTRBNS6F5:TaxField(fieldName == "Cret00BPTCTRBNS6F5");
  $Cret00BPTCTRBNS6F6:TaxField(fieldName == "Cret00BPTCTRBNS6F6");
  $Cret00BPTCTRBNS6F7:TaxField(fieldName == "Cret00BPTCTRBNS6F7");
  $Cret00BPTCTRBNS6F9:TaxField(fieldName == "Cret00BPTCTRBNS6F9");
  $Cret00BPTCTRBNS6F10:TaxField(fieldName == "Cret00BPTCTRBNS6F10");
  $Cret00BPTCTRBNS6F11:TaxField(fieldName == "Cret00BPTCTRBNS6F11");
  $Cret00BPTCTRBNS6F12:TaxField(fieldName == "Cret00BPTCTRBNS6F12");
  $Cret00BPTCTRBNS6F13:TaxField(fieldName == "Cret00BPTCTRBNS6F13");
  $Cret00BPTCTRBNS6F14:TaxField(fieldName == "Cret00BPTCTRBNS6F14");
  $Cret00BPTCTRBNS6F15:TaxField(fieldName == "Cret00BPTCTRBNS6F15",calValue==null);

  $Cret00BPTCTRBNS11F24:TaxField(fieldName == "Cret00BPTCTRBNS11F24");
  $Cret00BPTCTRBNS11F33:TaxField(fieldName == "Cret00BPTCTRBNS11F33");
  $Cret00BPTCTRBNS11F12:TaxField(fieldName == "Cret00BPTCTRBNS11F12");
    then
  //S6F6: Should be equal as S11F24, if not, S11F24 prevails
  //$Cret00BPTCTRBNS6F6.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F24.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS6F6);

  //S6F7: Should be equal as S11F33, if not, S11F33 prevails
  //$Cret00BPTCTRBNS6F7.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F33.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS6F7);
  
  //S6F11: Should be equal as S11F12, if not, S11F12 prevails
  //$Cret00BPTCTRBNS6F11.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F12.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS6F11);

  //S6F15=S6F5+S6F6+S6F7+S6F9-S6F10-S6F11-S6F12-S6F13-S6F14
  $Cret00BPTCTRBNS6F15.setCalValue(TaxMathUtils.calTaxOriginal(new OperatorWrapper($Cret00BPTCTRBNS6F5),new OperatorWrapper($Cret00BPTCTRBNS6F6,"+"),new OperatorWrapper($Cret00BPTCTRBNS6F7,"+"),
    new OperatorWrapper($Cret00BPTCTRBNS6F9,"+"),new OperatorWrapper($Cret00BPTCTRBNS6F10,"-"),new OperatorWrapper($Cret00BPTCTRBNS6F11,"-"),
    new OperatorWrapper($Cret00BPTCTRBNS6F12,"-"),new OperatorWrapper($Cret00BPTCTRBNS6F13,"-"),new OperatorWrapper($Cret00BPTCTRBNS6F14,"-")));
  assResult.compareAndSet($Cret00BPTCTRBNS6F15);
end
//----------Schedule 6: end--------------------------

//----------Schedule 7: start--------------------------
//Schedule 7 : Tax return for Service Business [1]
//S7F1: Should be equal as S6F15, if not, S6F15 prevails
rule "calc_S7_Cret00BPTCTRBNS7F1"
    when
  $Cret00BPTCTRBNS7F1:TaxField(fieldName == "Cret00BPTCTRBNS7F1",calValue==null);
  $Cret00BPTCTRBNS6F15:TaxField(fieldName == "Cret00BPTCTRBNS6F15");
    then
  $Cret00BPTCTRBNS7F1.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS6F15));
  assResult.compareAndSet($Cret00BPTCTRBNS7F1);
  //update($Cret00BPTCTRBNS7F1);
end

//Schedule 7 : Tax return for Service Business [3]
//S7F18=S7F2+S7F3..+S7F17
rule "calc_S7_Cret00BPTCTRBNS7F18"
    when
  $Cret00BPTCTRBNS7F2:TaxField(fieldName == "Cret00BPTCTRBNS7F2");
  $Cret00BPTCTRBNS7F3:TaxField(fieldName == "Cret00BPTCTRBNS7F3");
  $Cret00BPTCTRBNS7F4:TaxField(fieldName == "Cret00BPTCTRBNS7F4");
  $Cret00BPTCTRBNS7F38:TaxField(fieldName == "Cret00BPTCTRBNS7F38");
  $Cret00BPTCTRBNS7F5:TaxField(fieldName == "Cret00BPTCTRBNS7F5");
  $Cret00BPTCTRBNS7F6:TaxField(fieldName == "Cret00BPTCTRBNS7F6");
  $Cret00BPTCTRBNS7F7:TaxField(fieldName == "Cret00BPTCTRBNS7F7");
  $Cret00BPTCTRBNS7F8:TaxField(fieldName == "Cret00BPTCTRBNS7F8");
        $Cret00BPTCTRBNS7F9:TaxField(fieldName == "Cret00BPTCTRBNS7F9");
  $Cret00BPTCTRBNS7F10:TaxField(fieldName == "Cret00BPTCTRBNS7F10");
  $Cret00BPTCTRBNS7F11:TaxField(fieldName == "Cret00BPTCTRBNS7F11");
  $Cret00BPTCTRBNS7F12:TaxField(fieldName == "Cret00BPTCTRBNS7F12");
  $Cret00BPTCTRBNS7F13:TaxField(fieldName == "Cret00BPTCTRBNS7F13");
  $Cret00BPTCTRBNS7F14:TaxField(fieldName == "Cret00BPTCTRBNS7F14");
  $Cret00BPTCTRBNS7F15:TaxField(fieldName == "Cret00BPTCTRBNS7F15");
  $Cret00BPTCTRBNS7F16:TaxField(fieldName == "Cret00BPTCTRBNS7F16");
  $Cret00BPTCTRBNS7F38A:TaxField(fieldName == "Cret00BPTCTRBNS7F38A");
  $Cret00BPTCTRBNS7F18:TaxField(fieldName == "Cret00BPTCTRBNS7F18",calValue==null);
    then
  $Cret00BPTCTRBNS7F18.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F2, $Cret00BPTCTRBNS7F3, $Cret00BPTCTRBNS7F4,
    $Cret00BPTCTRBNS7F38, $Cret00BPTCTRBNS7F5, $Cret00BPTCTRBNS7F6, $Cret00BPTCTRBNS7F7, $Cret00BPTCTRBNS7F8, 
    $Cret00BPTCTRBNS7F9, $Cret00BPTCTRBNS7F10, $Cret00BPTCTRBNS7F11, $Cret00BPTCTRBNS7F12, $Cret00BPTCTRBNS7F13, 
    $Cret00BPTCTRBNS7F14, $Cret00BPTCTRBNS7F15, $Cret00BPTCTRBNS7F16,$Cret00BPTCTRBNS7F38A));  
   assResult.compareAndSet($Cret00BPTCTRBNS7F18);
  //update($Cret00BPTCTRBNS7F18);  
end

//Schedule 7 : Tax return for Service Business [4]
//S7F19=S7F1+S7F18
rule "calc_S7_Cret00BPTCTRBNS7F19"
    when
  $Cret00BPTCTRBNS7F1:TaxField(fieldName == "Cret00BPTCTRBNS7F1");
  $Cret00BPTCTRBNS7F18:TaxField(fieldName == "Cret00BPTCTRBNS7F18");
  $Cret00BPTCTRBNS7F19:TaxField(fieldName == "Cret00BPTCTRBNS7F19",calValue==null);
    then
  $Cret00BPTCTRBNS7F19.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F1, $Cret00BPTCTRBNS7F18));  
  assResult.compareAndSet($Cret00BPTCTRBNS7F19);
  //update($Cret00BPTCTRBNS7F19);  
end

//Schedule 7 : Tax return for Service Business [5]
//S7F20: Should be equal as S8F18, if not, S8F18 prevails
rule "calc_S7_Cret00BPTCTRBNS7F20"
    when
  $Cret00BPTCTRBNS7F20:TaxField(fieldName == "Cret00BPTCTRBNS7F20",calValue==null);
  $Cret00BPTCTRBNS8F18:TaxField(fieldName == "Cret00BPTCTRBNS8F18");
    then
  $Cret00BPTCTRBNS7F20.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F18));
  assResult.compareAndSet($Cret00BPTCTRBNS7F20);
  //update($Cret00BPTCTRBNS7F20);
end

//Schedule 7 : Tax return for Service Business [6]
//S7F21: This value should not exceeds S7F12, otherwise, system will limit this value to S7F12
rule "calc_S7_Cret00BPTCTRBNS7F21"
    when
  $Cret00BPTCTRBNS7F21:TaxField(fieldName == "Cret00BPTCTRBNS7F21",calValue==null);
  $Cret00BPTCTRBNS7F12:TaxField(fieldName == "Cret00BPTCTRBNS7F12");
    then
  String S7f21 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F21);
  String S7f12 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F12);
  if(TaxMathUtils.compareTo(S7f21, S7f12) > 0) {
    S7f21 = S7f12;
  }
  $Cret00BPTCTRBNS7F21.setCalValue(S7f21);
  assResult.compareAndSet($Cret00BPTCTRBNS7F21);
  //update($Cret00BPTCTRBNS7F21);
end

//Schedule 7 : Tax return for Service Business [7]
//S7F25=S7F2
// (+) S7F4 or S6F15*10%
// (System will take the smaller value, and if S6F15 is negative value, set this value be 0)
// (+) 25%*S7F3
// (+) 25%*S7F3 in previous year, if S7F3 has been declared in previous year
rule "calc_S7_Cret00BPTCTRBNS7F25"
    when
  $Cret00BPTCTRBNS6F15:TaxField(fieldName == "Cret00BPTCTRBNS6F15");
  $Cret00BPTCTRBNS7F2:TaxField(fieldName == "Cret00BPTCTRBNS7F2");
  $Cret00BPTCTRBNS7F3:TaxField(fieldName == "Cret00BPTCTRBNS7F3");
  $Cret00BPTCTRBNS7F4:TaxField(fieldName == "Cret00BPTCTRBNS7F4");
  $Cret00BPTCTRBNS7F25:TaxField(fieldName == "Cret00BPTCTRBNS7F25",calValue==null);

  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  String smallV = null;
  String s6f15 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS6F15);
  if(TaxMathUtils.compareTo(s6f15, "0") < 0) {
    smallV = TaxMathUtils.sum("0");
  }else {
    String S7f4 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F4);
    String m10_s6f15 = TaxMathUtils.mulitplyTax(s6f15, "0.1");
    if(TaxMathUtils.compareTo(S7f4, m10_s6f15) > 0) {
      smallV = m10_s6f15;
    }else {
      smallV = S7f4;
    }
  }
  String m25_S7f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS7F3.getNeedValue(), "0.25");
  String pvS7f3 = TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS7F3");
  String p_m25_S7f3 = TaxMathUtils.mulitplyTax(pvS7f3, "0.25");
  
  $Cret00BPTCTRBNS7F25.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS7F2.getNeedValue(), smallV, m25_S7f3, p_m25_S7f3));
  assResult.compareAndSet($Cret00BPTCTRBNS7F25);
  //update($Cret00BPTCTRBNS7F25);
end

//Schedule 7 : Tax return for Service Business [8]
//S7F26: This value should not exceeds S6F7, otherwise, system will limit this value to S6F7
rule "calc_S7_Cret00BPTCTRBNS7F26"
    when
  $Cret00BPTCTRBNS7F26:TaxField(fieldName == "Cret00BPTCTRBNS7F26",calValue==null);
  $Cret00BPTCTRBNS6F7:TaxField(fieldName == "Cret00BPTCTRBNS6F7");
    then
  String S7f26 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F26);
  String s6f7 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS6F7);
  if(TaxMathUtils.compareTo(S7f26, s6f7) > 0) {
    S7f26 = s6f7;
  }
  $Cret00BPTCTRBNS7F26.setCalValue(S7f26);
  assResult.compareAndSet($Cret00BPTCTRBNS7F26);
  //update($Cret00BPTCTRBNS7F26);
end

//Schedule 7 : Tax return for Service Business [9]
//S7F28=S7F20+S7F21+S7F22+S7F25+S7F26
rule "calc_S7_Cret00BPTCTRBNS7F28"
    when
  $Cret00BPTCTRBNS7F20:TaxField(fieldName == "Cret00BPTCTRBNS7F20");
  $Cret00BPTCTRBNS7F21:TaxField(fieldName == "Cret00BPTCTRBNS7F21");
  $Cret00BPTCTRBNS7F22:TaxField(fieldName == "Cret00BPTCTRBNS7F22");
  $Cret00BPTCTRBNS7F25:TaxField(fieldName == "Cret00BPTCTRBNS7F25");
  $Cret00BPTCTRBNS7F26:TaxField(fieldName == "Cret00BPTCTRBNS7F26");
  $Cret00BPTCTRBNS7F39:TaxField(fieldName == "Cret00BPTCTRBNS7F39");
  $Cret00BPTCTRBNS7F28:TaxField(fieldName == "Cret00BPTCTRBNS7F28",calValue==null);
    then
  $Cret00BPTCTRBNS7F28.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F20, $Cret00BPTCTRBNS7F21, 
    $Cret00BPTCTRBNS7F22, $Cret00BPTCTRBNS7F25, $Cret00BPTCTRBNS7F26,$Cret00BPTCTRBNS7F39));  
  assResult.compareAndSet($Cret00BPTCTRBNS7F28);
  //update($Cret00BPTCTRBNS7F28);  
end

//Schedule 7 : Tax return for Service Business [10]
//S7F37=S7F19-S7F28 OR calc by Validation Rule 
rule "calc_S7_Cret00BPTCTRBNS7F37"
    when
  $Cret00BPTCTRBNS7F3:TaxField(fieldName == "Cret00BPTCTRBNS7F3");
  $Cret00BPTCTRBNS7F19:TaxField(fieldName == "Cret00BPTCTRBNS7F19");
  $Cret00BPTCTRBNS7F28:TaxField(fieldName == "Cret00BPTCTRBNS7F28");
  $Cret00BPTCTRBNS7F37:TaxField(fieldName == "Cret00BPTCTRBNS7F37",calValue==null);
    then
  String S7f19 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS7F19);
  String S7f37 = TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS7F19, $Cret00BPTCTRBNS7F28);  
  if(TaxMathUtils.compareTo(S7f19, "0") > 0 && TaxMathUtils.compareTo(S7f37, "0") <= 0) {
    String m25_S7f3 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS7F3, 0.25);
    String m50_S7f28 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS7F28, 0.5);
    if(TaxMathUtils.compareTo(m25_S7f3, m50_S7f28) > 0) {
      S7f37 = TaxMathUtils.sum("0");
    }
  }
  $Cret00BPTCTRBNS7F37.setCalValue(S7f37);
  assResult.compareAndSet($Cret00BPTCTRBNS7F37);
  //update($Cret00BPTCTRBNS7F37);  
end


//Schedule 7 : Tax return for Service Business [2]
//calc S7F27 and S7F17 by Validation Rule 
rule "calc_S7_Cret00BPTCTRBNS7F27_AND_S7F17"
    when
  $Cret00BPTCTRBNS7F17_HIDDEN:TaxField(fieldName == "Cret00BPTCTRBNS7F17_HIDDEN",calValue==null);
  $Cret00BPTCTRBNS7F27:TaxField(fieldName == "Cret00BPTCTRBNS7F27",calValue==null);
  $Cret00BPTCTRBNS7F37:TaxField(fieldName == "Cret00BPTCTRBNS7F37");
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
    then
  /*
  String zero = TaxMathUtils.sum("0");
  String S7f29_pvs = TaxMathUtils.sum(TaxValidation.getPreviousFeildValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS7F29"));
    

    if(TaxMathUtils.compareTo(S7f29_pvs, zero) >= 0) {
    $Cret00BPTCTRBNS7F17_HIDDEN.setCalValue(zero);
    $Cret00BPTCTRBNS7F27.setCalValue(zero);
    }else {
    String abs_S7f29_pvs = TaxMathUtils.strAbs(S7f29_pvs);
    String S7f29_b6y = TaxMathUtils.sum(TaxValidation.getBeforeNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS7F29", Integer.valueOf(6)));
      
    if(TaxMathUtils.compareTo(S7f29_b6y, zero) >= 0) {
      $Cret00BPTCTRBNS7F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS7F27.setCalValue(abs_S7f29_pvs);
    }else {
      List S7f37List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS7F37", Integer.valueOf(5));  
      List S7f17List = TaxValidation.getSuccessivelyNYearsValue($Cret00BPTRetVerUid.getNeedValue(), "Cret00BPTCTRBNS7F17_HIDDEN", Integer.valueOf(5));
      //edit by 2016-12-26
      String fulfilledV = TaxMathUtils.sum(TaxMathUtils.sumListPositive(S7f37List), TaxMathUtils.sumListPositive(S7f17List));
      
      String abs_S7f29_b6y = TaxMathUtils.strAbs(S7f29_b6y);
      String noFulfilledv = TaxMathUtils.sub(fulfilledV, abs_S7f29_b6y);
      String abs_noFulfilledv = TaxMathUtils.strAbs(noFulfilledv);
         
      if(TaxMathUtils.compareTo(noFulfilledv, zero) >= 0) {
      $Cret00BPTCTRBNS7F17_HIDDEN.setCalValue(zero);
      $Cret00BPTCTRBNS7F27.setCalValue(abs_S7f29_pvs);
      }else {
      $Cret00BPTCTRBNS7F17_HIDDEN.setCalValue(abs_noFulfilledv);
      $Cret00BPTCTRBNS7F27.setCalValue(TaxMathUtils.sub(abs_S7f29_pvs, abs_noFulfilledv));
      }
    }
    }
  
  assResult.compareAndSet($Cret00BPTCTRBNS7F17_HIDDEN);
  //update($Cret00BPTCTRBNS7F17_HIDDEN);
*/
  String carriedForwardLoss = TaxValidation.getBptLossFromRestoreAndUpdateIsStatus($Cret00BPTRetVerUid.getNeedValue(),$Cret00BPTCTRBNS7F37.getNeedValue(),"Services");
  $Cret00BPTCTRBNS7F27.setCalValue(carriedForwardLoss);
    assResult.compareAndSet($Cret00BPTCTRBNS7F27);
  //update($Cret00BPTCTRBNS7F27);
end


//Schedule 7 : Tax return for Service Business [11]
//S7F29=S7F37-S7F27
rule "calc_S7_Cret00BPTCTRBNS7F29"
    when
  $Cret00BPTCTRBNS7F37:TaxField(fieldName == "Cret00BPTCTRBNS7F37");
  $Cret00BPTCTRBNS7F27:TaxField(fieldName == "Cret00BPTCTRBNS7F27");
  $Cret00BPTCTRBNS7F29:TaxField(fieldName == "Cret00BPTCTRBNS7F29",calValue==null);
    then
  $Cret00BPTCTRBNS7F29.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS7F37, $Cret00BPTCTRBNS7F27));  
  assResult.compareAndSet($Cret00BPTCTRBNS7F29);
  //update($Cret00BPTCTRBNS7F29);  
end

//Schedule 7 : Tax return for Service Business [12]
//S7F30: if S9F11 is positive, this value should be equal as S9F11 and S9F11 prevails when discrepancy, otherwise, leave it blank
rule "calc_S7_Cret00BPTCTRBNS7F30"
    when
  $Cret00BPTCTRBNS7F30:TaxField(fieldName == "Cret00BPTCTRBNS7F30",calValue==null);
  $Cret00BPTCTRBNS9F11:TaxField(fieldName == "Cret00BPTCTRBNS9F11");
    then
  String S7f30 = String.valueOf(0);
  String s9f11 = TaxMathUtils.nvlVal($Cret00BPTCTRBNS9F11);
  if(TaxMathUtils.compareTo(s9f11, String.valueOf(0)) > 0) {
    S7f30 = s9f11;
  }
  $Cret00BPTCTRBNS7F30.setCalValue(S7f30);
  assResult.compareAndSet($Cret00BPTCTRBNS7F30);
  //update($Cret00BPTCTRBNS7F30);
end

//Schedule 7 : Tax return for Service Business [13]
//S7F31=S6F6-S6F11
rule "calc_S7_Cret00BPTCTRBNS7F31"
    when
  $Cret00BPTCTRBNS6F6:TaxField(fieldName == "Cret00BPTCTRBNS6F6");
  $Cret00BPTCTRBNS6F11:TaxField(fieldName == "Cret00BPTCTRBNS6F11");
  $Cret00BPTCTRBNS7F31:TaxField(fieldName == "Cret00BPTCTRBNS7F31",calValue==null);
    then
  $Cret00BPTCTRBNS7F31.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS6F6, $Cret00BPTCTRBNS6F11));  
  assResult.compareAndSet($Cret00BPTCTRBNS7F31);
  //update($Cret00BPTCTRBNS7F31);  
end

//Schedule 7 : Tax return for Service Business [14]
//S7F36=S7F29-(S7F30+S7F31+S7F32+S7F33+S7F34+S7F35) 
rule "calc_S7_Cret00BPTCTRBNS7F36"
    when
  $Cret00BPTCTRBNS7F29:TaxField(fieldName == "Cret00BPTCTRBNS7F29");
  $Cret00BPTCTRBNS7F30:TaxField(fieldName == "Cret00BPTCTRBNS7F30");
  $Cret00BPTCTRBNS7F31:TaxField(fieldName == "Cret00BPTCTRBNS7F31");
  $Cret00BPTCTRBNS7F32:TaxField(fieldName == "Cret00BPTCTRBNS7F32");
  $Cret00BPTCTRBNS7F33:TaxField(fieldName == "Cret00BPTCTRBNS7F33");
  $Cret00BPTCTRBNS7F34:TaxField(fieldName == "Cret00BPTCTRBNS7F34");
  $Cret00BPTCTRBNS7F35:TaxField(fieldName == "Cret00BPTCTRBNS7F35");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36",calValue==null);
    then
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS7F30, $Cret00BPTCTRBNS7F31, $Cret00BPTCTRBNS7F32, 
    $Cret00BPTCTRBNS7F33, $Cret00BPTCTRBNS7F34, $Cret00BPTCTRBNS7F35);
  $Cret00BPTCTRBNS7F36.setCalValue(TaxMathUtils.sub($Cret00BPTCTRBNS7F29.getNeedValue(), sumV));  
  assResult.compareAndSet($Cret00BPTCTRBNS7F36);
  //update($Cret00BPTCTRBNS7F36);  
end
//----------Schedule 7: end----------------------------

//----------Schedule 8: start--------------------------
rule "calc_AssetsSubType_resultMap"
    when 
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid",calValue==null);
    then
  String tabTag = "tbl_01";
  String typeFeild = "Cret00BPTCTRBNS8F2_";
  String asstFeild = "Cret00BPTCTRBNS8F14_";
  String dptnFeild = "Cret00BPTCTRBNS8F13_";
  List feildList = new ArrayList();
  feildList.add(typeFeild);
  feildList.add(asstFeild);
  feildList.add(dptnFeild);

  Map resultMap = TaxValidation.getPreviousTabRowsValues($Cret00BPTRetVerUid.getNeedValue(), 
    tabTag, typeFeild, feildList); 
  assResult.setResultMap(resultMap);
end

//Schedule 8 : Schedule of Fixed Assets [1]
rule "calc_S8_Cret00BPTCTRBNS8F_LIST_15"
    when 
  $Cret00BPTCTRBNS8F1:TaxField(fieldName == "Cret00BPTCTRBNS8F1",cal==false);
  $Cret00BPTCTRBNS8F2:TaxField(fieldName == "Cret00BPTCTRBNS8F2",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F3:TaxField(fieldName == "Cret00BPTCTRBNS8F3",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F4:TaxField(fieldName == "Cret00BPTCTRBNS8F4",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F5:TaxField(fieldName == "Cret00BPTCTRBNS8F5",rowNum==$Cret00BPTCTRBNS8F1.rowNum);  
  $Cret00BPTCTRBNS8F6:TaxField(fieldName == "Cret00BPTCTRBNS8F6",rowNum==$Cret00BPTCTRBNS8F1.rowNum); 
        $Cret00BPTCTRBNS8F7:TaxField(fieldName == "Cret00BPTCTRBNS8F7",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
        $Cret00BPTCTRBNS8F8:TaxField(fieldName == "Cret00BPTCTRBNS8F8",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F9:TaxField(fieldName == "Cret00BPTCTRBNS8F9",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F10:TaxField(fieldName == "Cret00BPTCTRBNS8F10",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
        $Cret00BPTCTRBNS8F11:TaxField(fieldName == "Cret00BPTCTRBNS8F11",rowNum==$Cret00BPTCTRBNS8F1.rowNum); 
  $Cret00BPTCTRBNS8F12:TaxField(fieldName == "Cret00BPTCTRBNS8F12",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
        $Cret00BPTCTRBNS8F13:TaxField(fieldName == "Cret00BPTCTRBNS8F13",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F14:TaxField(fieldName == "Cret00BPTCTRBNS8F14",rowNum==$Cret00BPTCTRBNS8F1.rowNum);
  $Cret00BPTCTRBNS8F15:TaxField(fieldName == "Cret00BPTCTRBNS8F15"); 
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid",calValue==null);
    then
  //--- Get previous start-----
  //String typeFeild = "Cret00BPTCTRBNS8F2_";
  String asstFeild = "Cret00BPTCTRBNS8F14_";
  String dptnFeild = "Cret00BPTCTRBNS8F13_";
  
  Map pvs14Map = new HashMap();
  Map pvs13Map = new HashMap();
  Map resultMap = assResult.getResultMap();
  if(resultMap != null) {
    pvs14Map = resultMap.get(asstFeild);
    pvs13Map = resultMap.get(dptnFeild);
  }
  //--- Get previous end-----

  String s8f2 = $Cret00BPTCTRBNS8F2.getNeedValue();
  //S8F3: Should be equal as S8F14 of previous BPT return according to the sub type 0f business
  String s8f3 = null;
  if(TaxMathUtils.isNotNull(s8f2) && pvs14Map != null) {
    s8f3 = (String)pvs14Map.get(s8f2);
  }
  if(!TaxMathUtils.isNotNull(s8f3)) {
    //s8f3 = String.valueOf(0.00);
  s8f3 = $Cret00BPTCTRBNS8F3.getOriginalValue();
  }
  $Cret00BPTCTRBNS8F3.setCalValue(s8f3);
  assResult.compareAndSet($Cret00BPTCTRBNS8F3);
  //update($Cret00BPTCTRBNS8F3);
    
  //S8F6=S8F3+S8F4+S8F5
        //$Cret00BPTCTRBNS8F6.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F3, $Cret00BPTCTRBNS8F4, $Cret00BPTCTRBNS8F5));
  //S8F6=S8F3+S8F4-S8F5
  String temp_m = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F3, $Cret00BPTCTRBNS8F4);
  $Cret00BPTCTRBNS8F6.setCalValue(TaxMathUtils.sub(temp_m,$Cret00BPTCTRBNS8F5.getNeedValue()));
  assResult.compareAndSet($Cret00BPTCTRBNS8F6);
  //update($Cret00BPTCTRBNS8F6);

  //S8F7: Should be equal as S8F13 of previous BPT return according to the sub type 0f business
  String s8f7 = null;
  if(TaxMathUtils.isNotNull(s8f2) && pvs13Map != null) {
    s8f7 = (String)pvs13Map.get(s8f2);
  }
  if(!TaxMathUtils.isNotNull(s8f7)) {
    s8f7 = String.valueOf(0.00);
  }
  $Cret00BPTCTRBNS8F7.setCalValue(s8f7);
  assResult.compareAndSet($Cret00BPTCTRBNS8F7);
  //update($Cret00BPTCTRBNS8F7);

  //S8F9: S8F9=S8F3*S8F8
  String s8f3Mul8 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS8F3, $Cret00BPTCTRBNS8F8);
  $Cret00BPTCTRBNS8F9.setCalValue(TaxMathUtils.division(s8f3Mul8, String.valueOf(100)));
  assResult.compareAndSet($Cret00BPTCTRBNS8F9);
  //update($Cret00BPTCTRBNS8F9);

  //S8F10: S8F10=(S8F4*S8F8)/2
  String s8f4Mul8 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS8F4, $Cret00BPTCTRBNS8F8);
  $Cret00BPTCTRBNS8F10.setCalValue(TaxMathUtils.division(s8f4Mul8, String.valueOf(200)));
  assResult.compareAndSet($Cret00BPTCTRBNS8F10);
  //update($Cret00BPTCTRBNS8F10);
  
  //S8F11: S8F11=(S8F5*S8F8)/2
  String s8f5Mul8 = TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS8F5, $Cret00BPTCTRBNS8F8);
  $Cret00BPTCTRBNS8F11.setCalValue(TaxMathUtils.division(s8f5Mul8, String.valueOf(200)));
  assResult.compareAndSet($Cret00BPTCTRBNS8F11);
  //update($Cret00BPTCTRBNS8F11);

  //S8F12: S8F12=S8F9+S8F10-S8F11
  String sumS8f9_10 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F9, $Cret00BPTCTRBNS8F10);
        $Cret00BPTCTRBNS8F12.setCalValue(TaxMathUtils.sub(sumS8f9_10, $Cret00BPTCTRBNS8F11.getNeedValue()));
  assResult.compareAndSet($Cret00BPTCTRBNS8F12);
  //update($Cret00BPTCTRBNS8F12);

  //S8F13: S8F13=S8F7+S8F12
        $Cret00BPTCTRBNS8F13.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F7, $Cret00BPTCTRBNS8F12));
  assResult.compareAndSet($Cret00BPTCTRBNS8F13);
  //update($Cret00BPTCTRBNS8F13);
  
  //S8F14: S8F14=S8F6-S8F13
  $Cret00BPTCTRBNS8F14.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS8F6, $Cret00BPTCTRBNS8F13));
  assResult.compareAndSet($Cret00BPTCTRBNS8F14);
  //update($Cret00BPTCTRBNS8F14);

  //S8F15: S8F15=totals of S8F12
  //$Cret00BPTCTRBNS8F15.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS8F15.getCalValue(), $Cret00BPTCTRBNS8F12.getNeedValue()));
  //$Cret00BPTCTRBNS8F15.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F15,$Cret00BPTCTRBNS8F12));
  $Cret00BPTCTRBNS8F15.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS8F15.getCalValue(),$Cret00BPTCTRBNS8F12.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS8F15);
  //update($Cret00BPTCTRBNS8F15);

  String s8f5 = ($Cret00BPTCTRBNS8F5.getNeedValue() == null)?String.valueOf(0):$Cret00BPTCTRBNS8F5.getNeedValue();
  if(TaxMathUtils.isNotNull(s8f2)) {
    Map subTypeMap = assResult.getSubTypeMap();
    if(subTypeMap.containsKey(s8f2)) {
      subTypeMap.put(s8f2, TaxMathUtils.sum((String)subTypeMap.get(s8f2), s8f5));
    }else {
      subTypeMap.put(s8f2, s8f5);
    }  
    assResult.setSubTypeMap(subTypeMap);
  }

  $Cret00BPTCTRBNS8F1.setCal(true);
end

//Schedule 8 : Schedule of Fixed Assets [2]
rule "calc_S8_Cret00BPTCTRBNS8F15_EQUAL"
    when 
  $Cret00BPTCTRBNS8F15:TaxField(fieldName == "Cret00BPTCTRBNS8F15");
  $Cret00BPTCTRBNS8F16:TaxField(fieldName == "Cret00BPTCTRBNS8F16");
  $Cret00BPTCTRBNS8F17:TaxField(fieldName == "Cret00BPTCTRBNS8F17");  
  $Cret00BPTCTRBNS8F18:TaxField(fieldName == "Cret00BPTCTRBNS8F18",calValue==null); 
    then
    String msg = "";
    if(TaxMathUtils.compareEquals($Cret00BPTCTRBNS8F15.getOriginalValue(), $Cret00BPTCTRBNS8F15.getCalValue())) {
        msg = "com.cacss.itas.ret.bpt.fixed.assets.needs.manual.adjustment";
    }else {
        msg = "com.cacss.itas.ret.bpt.fixed.assets.needs.manual.adjustment.due.calc";
    }
  String s8f15FieldName_p = "com.cacss.itas.ret.returnBPTCTRBN.S8F15";
    assResult.compareAndSet($Cret00BPTCTRBNS8F15);
    
    //Should be equal as (S8F16+S8F17+S8F18), if not, return will workflow to Data Entry Supervisor with 
    //message 'Distribution of Depreciation of fixed assets needs manual adjustment.'
    String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS8F16, $Cret00BPTCTRBNS8F17, $Cret00BPTCTRBNS8F18);
    if(TaxMathUtils.compareTo($Cret00BPTCTRBNS8F15.getNeedValue(), sumV) != 0) {
      assResult.addMandatoryFields("calc_S8_Cret00BPTCTRBNS8F15_EQUAL", msg+"@"+s8f15FieldName_p+"@"+$Cret00BPTCTRBNS8F15.getNeedValue());
    }
end
//----------Schedule 8: end----------------------------

//----------Schedule 9: start--------------------------
//Schedule 9 : Schedule for disposed assets during the year [1]
rule "calc_S9_Cret00BPTCTRCS9F_LIST_8"
    when 
  $Cret00BPTCTRBNS9F1:TaxField(fieldName == "Cret00BPTCTRBNS9F1",cal==false);
  $Cret00BPTCTRBNS9F2:TaxField(fieldName == "Cret00BPTCTRBNS9F2",rowNum==$Cret00BPTCTRBNS9F1.rowNum);
  $Cret00BPTCTRBNS9F3:TaxField(fieldName == "Cret00BPTCTRBNS9F3",rowNum==$Cret00BPTCTRBNS9F1.rowNum);
  $Cret00BPTCTRBNS9F4:TaxField(fieldName == "Cret00BPTCTRBNS9F4",rowNum==$Cret00BPTCTRBNS9F1.rowNum);
  $Cret00BPTCTRBNS9F5:TaxField(fieldName == "Cret00BPTCTRBNS9F5",rowNum==$Cret00BPTCTRBNS9F1.rowNum);  
  $Cret00BPTCTRBNS9F6:TaxField(fieldName == "Cret00BPTCTRBNS9F6",rowNum==$Cret00BPTCTRBNS9F1.rowNum); 
        $Cret00BPTCTRBNS9F7:TaxField(fieldName == "Cret00BPTCTRBNS9F7",rowNum==$Cret00BPTCTRBNS9F1.rowNum);
        $Cret00BPTCTRBNS9F8:TaxField(fieldName == "Cret00BPTCTRBNS9F8");   
    then
  String s9f2 = $Cret00BPTCTRBNS9F2.getNeedValue();
  //S9F5: Should be equal as S8F5 according to the sub type of business, if not, S8F5 prevails
  Map subTypeMap = assResult.getSubTypeMap();
  String s8f5 = null;
  if(TaxMathUtils.isNotNull(s9f2) && subTypeMap != null) {
    s8f5 = (String)subTypeMap.get(s9f2);
  }
  if(!TaxMathUtils.isNotNull(s8f5)) {
    s8f5 = String.valueOf(0.00);
  }
  $Cret00BPTCTRBNS9F5.setCalValue(s8f5);
  assResult.compareAndSet($Cret00BPTCTRBNS9F5);
  //update($Cret00BPTCTRBNs8f5);
  
  //S9F7=S9F4-(S9F5-S9F6)
  String sub5V6 = TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS9F5, $Cret00BPTCTRBNS9F6);
        $Cret00BPTCTRBNS9F7.setCalValue(TaxMathUtils.sub($Cret00BPTCTRBNS9F4.getNeedValue(), sub5V6));
  assResult.compareAndSet($Cret00BPTCTRBNS9F7);
  //update($Cret00BPTCTRBNS9F7);

  //S9F8=totals of S9F7
  $Cret00BPTCTRBNS9F8.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS9F8.getCalValue(), $Cret00BPTCTRBNS9F7.getNeedValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS9F8);
  //update($Cret00BPTCTRBNS9F8);

  $Cret00BPTCTRBNS9F1.setCal(true);
end

//Schedule 9 : Schedule for disposed assets during the year [2]
rule "calc_S9_Cret00BPTCTRBNS9F8_EQUAL"
    when 
  $Cret00BPTCTRBNS9F8:TaxField(fieldName == "Cret00BPTCTRBNS9F8");
  $Cret00BPTCTRBNS9F9:TaxField(fieldName == "Cret00BPTCTRBNS9F9");
  $Cret00BPTCTRBNS9F10:TaxField(fieldName == "Cret00BPTCTRBNS9F10");  
  $Cret00BPTCTRBNS9F11:TaxField(fieldName == "Cret00BPTCTRBNS9F11",calValue==null); 
    then
  assResult.compareAndSet($Cret00BPTCTRBNS9F8);
  // Should be equal as (S9F9+S9F10+S9F11), if not, return will workflow to Data Entry Supervisor with message 'Distribution of profit of disposed fixed assets needs manual adjustment.'
  String msg = "com.cacss.itas.ret.bpt.disposed.fixed.assets.needs.manual.adjustment";
  String s9f8FieldName_p = "com.cacss.itas.ret.returnBPTCTRBN.S9F8";
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS9F9, $Cret00BPTCTRBNS9F10, $Cret00BPTCTRBNS9F11);
  if(TaxMathUtils.compareTo($Cret00BPTCTRBNS9F8.getNeedValue(), sumV) != 0) {
    assResult.addMandatoryFields("calc_S9_Cret00BPTCTRBNS9F8_EQUAL", msg+"@"+s9f8FieldName_p+"@"+$Cret00BPTCTRBNS9F8.getNeedValue());
  }
end
//----------Schedule 9: end----------------------------

//----------Schedule 10: start--------------------------
//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F1_TO_6"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F1:TaxField(fieldName == "Cret00BPTCTRBNS10F1",calValue==null);
  $Cret00BPTCTRBNS10F2:TaxField(fieldName == "Cret00BPTCTRBNS10F2",calValue==null);
  $Cret00BPTCTRBNS10F3:TaxField(fieldName == "Cret00BPTCTRBNS10F3",calValue==null);
  $Cret00BPTCTRBNS10F4:TaxField(fieldName == "Cret00BPTCTRBNS10F4",calValue==null);
  $Cret00BPTCTRBNS10F5:TaxField(fieldName == "Cret00BPTCTRBNS10F5",calValue==null);
  $Cret00BPTCTRBNS10F6:TaxField(fieldName == "Cret00BPTCTRBNS10F6",calValue==null);
   
  $Cret00BPTRetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTcreg01Tin:TaxField(fieldName == "Cret00BPTcreg01Tin");
    then
  String zero = String.valueOf(0);
  String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"m");
  String taxpayerType = TaxValidation.getTaxPayerType($Cret00BPTTaxpayerUid.needValue);
  //If taxpayer is partnership business name but not a oil service company, cigarette and tabacco company
  //If taxpayer is individual business name but not a oil service company, cigarette and tabacco company
  //If taxpayer is individual business name but not a oil service company, cigarette and tabacco company
  String s10f1 = String.valueOf(0);
  String s10f3 = String.valueOf(0);
  String s10f5 = String.valueOf(0);
  //if("OIL".equals(codeBus) || "CIGARETTES_TOBACCO".equals(codeBus)){
  if("10_NAT_TRADE".equals(codeBus) || "2_NAT_TRADE".equals(codeBus)){

  }else{
    if("partnership".equals(taxpayerType)){
      //S10F1=S3F36+S5F36+S7F36
      s10f1 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36);
    }else{
      //S10F3=S3F36+S7F36
      s10f3 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS7F36);
    
      //S10F5=S5F36
      s10f5 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS5F36);
    }
  }
  $Cret00BPTCTRBNS10F1.setCalValue(TaxMathUtils.sum(s10f1));
  //S10F2 = S10F1 * 15%
  //$Cret00BPTCTRBNS10F2.setCalValue(TaxMathUtils.mulitplyTax(s10f1,"0.15"));

  String myZero = TaxMathUtils.sum("0");
  if(TaxMathUtils.isNotNull(s10f1)&&TaxMathUtils.compareTo(s10f1,myZero) > 0){
  $Cret00BPTCTRBNS10F2.setCalValue(TaxMathUtils.mulitplyTax(s10f1,"0.15"));
  }else{
  $Cret00BPTCTRBNS10F2.setCalValue(myZero);
  }

  $Cret00BPTCTRBNS10F3.setCalValue(TaxMathUtils.sum(s10f3));
  //S10F4 calculate according to the tax rate table
  String s10f4 = TaxValidation.calcTaxPable("BPT","comm",$Cret00BPTRetVerUid.needValue,s10f3,s10f5);
  //$Cret00BPTCTRBNS10F4.setCalValue(TaxMathUtils.sum(s10f4));
  if(TaxMathUtils.isNotNull(s10f4)&&TaxMathUtils.compareTo(s10f4,myZero) > 0){
  $Cret00BPTCTRBNS10F4.setCalValue(s10f4);
  }else{
  $Cret00BPTCTRBNS10F4.setCalValue(myZero);
  }
  $Cret00BPTCTRBNS10F5.setCalValue(TaxMathUtils.sum(s10f5));
  //S10F6 calculate according to the tax rate table
  //String s10f6 = TaxValidation.calcIndustrialRate(s10f5);
  String s10f6 = TaxValidation.calcTaxPable("BPT","indu",$Cret00BPTRetVerUid.needValue,s10f3,s10f5);
  //$Cret00BPTCTRBNS10F6.setCalValue(TaxMathUtils.sum(s10f6));
  if(TaxMathUtils.isNotNull(s10f6)&&TaxMathUtils.compareTo(s10f6,myZero) > 0){
  $Cret00BPTCTRBNS10F6.setCalValue(s10f6);
  }else{
  $Cret00BPTCTRBNS10F6.setCalValue(myZero);
  }
  System.out.println("@$Cret00BPTCTRBNS10F1.calValue="+$Cret00BPTCTRBNS10F1.calValue);
  assResult.compareAndSet($Cret00BPTCTRBNS10F1);
  assResult.compareAndSet($Cret00BPTCTRBNS10F2);
  assResult.compareAndSet($Cret00BPTCTRBNS10F3);
  assResult.compareAndSet($Cret00BPTCTRBNS10F4);
  assResult.compareAndSet($Cret00BPTCTRBNS10F5);
  assResult.compareAndSet($Cret00BPTCTRBNS10F6);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F9_TO_10"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F9:TaxField(fieldName == "Cret00BPTCTRBNS10F9" ,calValue==null);
  $Cret00BPTCTRBNS10F10:TaxField(fieldName == "Cret00BPTCTRBNS10F10",calValue==null);

  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTcreg01Tin:TaxField(fieldName == "Cret00BPTcreg01Tin");
    then
  String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"m");
    
  //If taxpayer is cigarette and tabacco company
  String s10f9 = String.valueOf(0);
  //if("CIGARETTES_TOBACCO".equals(codeBus)){
  if("2_NAT_TRADE".equals(codeBus)){
    //S10F9=S3F36+S5F36+S7F36
    s10f9 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36);
  }
  $Cret00BPTCTRBNS10F9.setCalValue(TaxMathUtils.sum(s10f9));
  assResult.compareAndSet($Cret00BPTCTRBNS10F9);

  //S10F10 = S10F9 * 30%
  //$Cret00BPTCTRBNS10F10.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F9.getNeedValue(),"0.3"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F9.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F9.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F10.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F9.getNeedValue(),"0.3"));
  }else{
  $Cret00BPTCTRBNS10F10.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F10);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F11_TO_12"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F11:TaxField(fieldName == "Cret00BPTCTRBNS10F11",calValue==null);
  $Cret00BPTCTRBNS10F12:TaxField(fieldName == "Cret00BPTCTRBNS10F12",calValue==null);

  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTcreg01Tin:TaxField(fieldName == "Cret00BPTcreg01Tin");
    then
  String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"s");
  
  //If type of business of taxpayer is determined as a
  String s10f11 = String.valueOf(0);
  //if("EXPLORATION_EXTRACTION_OIL_GAS".equals(codeBus)){
  if(null!=codeBus&&codeBus.contains("119_NAT_ACTIVITY")){
  //if("Gas& oils Distribution".equals(codeBus)){  
    //S10F11=S3F36+S5F36+S7F36
    s10f11 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36); 
  }
  $Cret00BPTCTRBNS10F11.setCalValue(TaxMathUtils.sum(s10f11));
  assResult.compareAndSet($Cret00BPTCTRBNS10F11);

  //S10F12 = S10F11 * 35%
  //$Cret00BPTCTRBNS10F12.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F11.getNeedValue(),"0.35"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F11.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F11.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F12.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F11.getNeedValue(),"0.35"));
  }else{
  $Cret00BPTCTRBNS10F12.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F12); 
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F13_TO_14"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F13:TaxField(fieldName == "Cret00BPTCTRBNS10F13",calValue==null);
  $Cret00BPTCTRBNS10F14:TaxField(fieldName == "Cret00BPTCTRBNS10F14",calValue==null);

  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTcreg01Tin:TaxField(fieldName == "Cret00BPTcreg01Tin");
    then
  String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"s");

  //If type of business of taxpayer is determined as b
  String s10f13 = String.valueOf(0);
  //if("OIL_GAS_DISTRIBUTION".equals(codeBus)){
  if(null!=codeBus&&(codeBus.contains("54_NAT_ACTIVITY")||codeBus.contains("105_NAT_ACTIVITY"))){
  //S10F9=S3F36+S5F36+S7F36
    s10f13 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36);
  }
  $Cret00BPTCTRBNS10F13.setCalValue(TaxMathUtils.sum(s10f13));
  assResult.compareAndSet($Cret00BPTCTRBNS10F13);

  //S10F14 = S10F13 * 15%
  //$Cret00BPTCTRBNS10F14.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F13.getNeedValue(),"0.15"));
   if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F13.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F13.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F14.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F13.getNeedValue(),"0.15"));
  }else{
  $Cret00BPTCTRBNS10F14.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F14);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F15_TO_16"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F15:TaxField(fieldName == "Cret00BPTCTRBNS10F15",calValue==null);
  $Cret00BPTCTRBNS10F16:TaxField(fieldName == "Cret00BPTCTRBNS10F16",calValue==null);

  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTcreg01Tin:TaxField(fieldName == "Cret00BPTcreg01Tin");
    then
  String codeBus=TaxValidation.getTaxpayerBus($Cret00BPTcreg01Tin.needValue,$Cret00BPTTaxpayerUid.needValue,"m");

  //If type of business of taxpayer is determined as c
  String s10f15 = String.valueOf(0);
  //if("MINING".equals(codeBus)){
  if("12_NAT_TRADE".equals(codeBus)){  
    s10f15 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36);
  }
  $Cret00BPTCTRBNS10F15.setCalValue(TaxMathUtils.sum(s10f15));
  assResult.compareAndSet($Cret00BPTCTRBNS10F15);

  //S10F16 = S10F15 * 15%
  //$Cret00BPTCTRBNS10F16.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F15.getNeedValue(),"0.15")); 
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F15.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F15.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F16.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F15.getNeedValue(),"0.15"));
  }else{
  $Cret00BPTCTRBNS10F16.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F16);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F19_TO_20"
    when
  $Cret00BPTCTRBNS3F36:TaxField(fieldName == "Cret00BPTCTRBNS3F36");
  $Cret00BPTCTRBNS5F36:TaxField(fieldName == "Cret00BPTCTRBNS5F36");
  $Cret00BPTCTRBNS7F36:TaxField(fieldName == "Cret00BPTCTRBNS7F36");

  $Cret00BPTCTRBNS10F19:TaxField(fieldName == "Cret00BPTCTRBNS10F19",calValue==null);
  $Cret00BPTCTRBNS10F20:TaxField(fieldName == "Cret00BPTCTRBNS10F20",calValue==null);
    then
  //[Reserved field]: If taxpayer have totally exempted from BPT by Investment Law
  String codeExempted = "NO";

  String s10f19 = String.valueOf(0);
  if("YES".equals(codeExempted)) {
    //S10F19=S3F36+S5F36+S7F36
    s10f19 = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F36, $Cret00BPTCTRBNS5F36, $Cret00BPTCTRBNS7F36);
  }
  $Cret00BPTCTRBNS10F19.setCalValue(TaxMathUtils.sum(s10f19));
  assResult.compareAndSet($Cret00BPTCTRBNS10F19);

  //S10F20 = S10F19 * 5%
  //$Cret00BPTCTRBNS10F20.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F19.getNeedValue(),"0.05"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F19.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F19.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F20.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F19.getNeedValue(),"0.05"));
  }else{
  $Cret00BPTCTRBNS10F20.setCalValue(TaxMathUtils.sum("0"));
  }
    assResult.compareAndSet($Cret00BPTCTRBNS10F20);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F7_TO_8"
    when
  $Cret00BPTCTRBNS3F31:TaxField(fieldName == "Cret00BPTCTRBNS3F31");
  $Cret00BPTCTRBNS5F31:TaxField(fieldName == "Cret00BPTCTRBNS5F31");
  $Cret00BPTCTRBNS7F31:TaxField(fieldName == "Cret00BPTCTRBNS7F31");

  $Cret00BPTCTRBNS10F7:TaxField(fieldName == "Cret00BPTCTRBNS10F7",calValue==null);
  $Cret00BPTCTRBNS10F8:TaxField(fieldName == "Cret00BPTCTRBNS10F8",calValue==null);
    then
  //S10F7 = S3F31+S5F31+S7F31
  $Cret00BPTCTRBNS10F7.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F31, 
    $Cret00BPTCTRBNS5F31, $Cret00BPTCTRBNS7F31));
  assResult.compareAndSet($Cret00BPTCTRBNS10F7);

  //S10F8 = S10F7 * 10%    
  //$Cret00BPTCTRBNS10F8.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F7.getNeedValue(),"0.1"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F7.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F7.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F8.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F7.getNeedValue(),"0.1"));
  }else{
  $Cret00BPTCTRBNS10F8.setCalValue(TaxMathUtils.sum("0"));
  }
    assResult.compareAndSet($Cret00BPTCTRBNS10F8);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F17_TO_18"
    when
  $Cret00BPTCTRBNS9F8:TaxField(fieldName == "Cret00BPTCTRBNS9F8");

  $Cret00BPTCTRBNS10F17:TaxField(fieldName == "Cret00BPTCTRBNS10F17",calValue==null);
  $Cret00BPTCTRBNS10F18:TaxField(fieldName == "Cret00BPTCTRBNS10F18",calValue==null);
    then
  //S10F17: Should be equal as S9F8, if not, S9F8 prevails
  //$Cret00BPTCTRBNS10F17.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS9F8));
  $Cret00BPTCTRBNS10F17.setCalValue($Cret00BPTCTRBNS9F8.needValue);
  assResult.compareAndSet($Cret00BPTCTRBNS10F17);

  //S10F18 = S10F17 * 15%
  //$Cret00BPTCTRBNS10F18.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F17.getNeedValue(),"0.15"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F17.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F17.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F18.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F17.getNeedValue(),"0.15"));
  }else{
  $Cret00BPTCTRBNS10F18.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F18);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F21_TO_22"
    when
  $Cret00BPTCTRBNS3F32:TaxField(fieldName == "Cret00BPTCTRBNS3F32");
  $Cret00BPTCTRBNS5F32:TaxField(fieldName == "Cret00BPTCTRBNS5F32");
  $Cret00BPTCTRBNS7F32:TaxField(fieldName == "Cret00BPTCTRBNS7F32");

  $Cret00BPTCTRBNS10F21:TaxField(fieldName == "Cret00BPTCTRBNS10F21",calValue==null);
  $Cret00BPTCTRBNS10F22:TaxField(fieldName == "Cret00BPTCTRBNS10F22",calValue==null);
    then
  //S10F21=S3F32+S5F32+S7F32
  $Cret00BPTCTRBNS10F21.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F32,
    $Cret00BPTCTRBNS5F32, $Cret00BPTCTRBNS7F32));
  assResult.compareAndSet($Cret00BPTCTRBNS10F21);
  //S10F22 = S10F21 * 2%
  //$Cret00BPTCTRBNS10F22.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F21.getNeedValue(),"0.02"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F21.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F21.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F22.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F21.getNeedValue(),"0.02"));
  }else{
  $Cret00BPTCTRBNS10F22.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F22);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F23_TO_24"
    when
  $Cret00BPTCTRBNS3F33:TaxField(fieldName == "Cret00BPTCTRBNS3F33");
  $Cret00BPTCTRBNS5F33:TaxField(fieldName == "Cret00BPTCTRBNS5F33");
  $Cret00BPTCTRBNS7F33:TaxField(fieldName == "Cret00BPTCTRBNS7F33");
   
  $Cret00BPTCTRBNS10F23:TaxField(fieldName == "Cret00BPTCTRBNS10F23",calValue==null);
  $Cret00BPTCTRBNS10F24:TaxField(fieldName == "Cret00BPTCTRBNS10F24",calValue==null);
    then
  //S10F23=S3F33+S5F33+S7F33
  $Cret00BPTCTRBNS10F23.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F33,
    $Cret00BPTCTRBNS5F33,$Cret00BPTCTRBNS7F33));
  assResult.compareAndSet($Cret00BPTCTRBNS10F23);
  //S10F24 = S10F23 * 2%
  //$Cret00BPTCTRBNS10F24.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F23.getNeedValue(),"0.02"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F23.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F23.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F24.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F23.getNeedValue(),"0.02"));
  }else{
  $Cret00BPTCTRBNS10F24.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F24);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F25_TO_26"
    when
  $Cret00BPTCTRBNS3F34:TaxField(fieldName == "Cret00BPTCTRBNS3F34");
  $Cret00BPTCTRBNS5F34:TaxField(fieldName == "Cret00BPTCTRBNS5F34");
  $Cret00BPTCTRBNS7F34:TaxField(fieldName == "Cret00BPTCTRBNS7F34");
    
  $Cret00BPTCTRBNS10F25:TaxField(fieldName == "Cret00BPTCTRBNS10F25",calValue==null);
  $Cret00BPTCTRBNS10F26:TaxField(fieldName == "Cret00BPTCTRBNS10F26",calValue==null);
    then
  //S10F25=S3F34+S5F34+S7F34
  $Cret00BPTCTRBNS10F25.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F34,
    $Cret00BPTCTRBNS5F34, $Cret00BPTCTRBNS7F34));
  assResult.compareAndSet($Cret00BPTCTRBNS10F25);
  //S10F26 = S10F25 * 2%
  //$Cret00BPTCTRBNS10F26.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F25.getNeedValue(),"0.02"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F25.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F25.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F26.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F25.getNeedValue(),"0.02"));
  }else{
  $Cret00BPTCTRBNS10F26.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F26);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F27_TO_28"
    when
  $Cret00BPTCTRBNS3F35:TaxField(fieldName == "Cret00BPTCTRBNS3F35");
  $Cret00BPTCTRBNS5F35:TaxField(fieldName == "Cret00BPTCTRBNS5F35");
  $Cret00BPTCTRBNS7F35:TaxField(fieldName == "Cret00BPTCTRBNS7F35");

  $Cret00BPTCTRBNS10F27:TaxField(fieldName == "Cret00BPTCTRBNS10F27",calValue==null);
  $Cret00BPTCTRBNS10F28:TaxField(fieldName == "Cret00BPTCTRBNS10F28",calValue==null);
    then
  //S10F27=S3F35+S5F35+S7F35
  $Cret00BPTCTRBNS10F27.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS3F35,
    $Cret00BPTCTRBNS5F35, $Cret00BPTCTRBNS7F35));
  assResult.compareAndSet($Cret00BPTCTRBNS10F27);
  //S10F28 = S10F27 * 2%
  //$Cret00BPTCTRBNS10F28.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F27.getNeedValue(),"0.02"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F27.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F27.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F28.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F27.getNeedValue(),"0.02"));
  }else{
  $Cret00BPTCTRBNS10F28.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F28);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F29"
    when
  $Cret00BPTCTRBNS10F2:TaxField(fieldName == "Cret00BPTCTRBNS10F2");
  $Cret00BPTCTRBNS10F4:TaxField(fieldName == "Cret00BPTCTRBNS10F4");
  $Cret00BPTCTRBNS10F6:TaxField(fieldName == "Cret00BPTCTRBNS10F6");
  $Cret00BPTCTRBNS10F8:TaxField(fieldName == "Cret00BPTCTRBNS10F8");
  $Cret00BPTCTRBNS10F10:TaxField(fieldName == "Cret00BPTCTRBNS10F10");
  $Cret00BPTCTRBNS10F12:TaxField(fieldName == "Cret00BPTCTRBNS10F12");
  $Cret00BPTCTRBNS10F14:TaxField(fieldName == "Cret00BPTCTRBNS10F14");
  $Cret00BPTCTRBNS10F16:TaxField(fieldName == "Cret00BPTCTRBNS10F16");
  $Cret00BPTCTRBNS10F18:TaxField(fieldName == "Cret00BPTCTRBNS10F18");
  $Cret00BPTCTRBNS10F20:TaxField(fieldName == "Cret00BPTCTRBNS10F20");
  $Cret00BPTCTRBNS10F22:TaxField(fieldName == "Cret00BPTCTRBNS10F22");
  $Cret00BPTCTRBNS10F24:TaxField(fieldName == "Cret00BPTCTRBNS10F24");
  $Cret00BPTCTRBNS10F26:TaxField(fieldName == "Cret00BPTCTRBNS10F26");
  $Cret00BPTCTRBNS10F28:TaxField(fieldName == "Cret00BPTCTRBNS10F28");

  $Cret00BPTCTRBNS10F29:TaxField(fieldName == "Cret00BPTCTRBNS10F29",calValue==null);
    then
  //S10F29 = Sum of the payable tax (S10F2/S10F4..S10F28)
  $Cret00BPTCTRBNS10F29.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS10F2,$Cret00BPTCTRBNS10F4,
    $Cret00BPTCTRBNS10F6,$Cret00BPTCTRBNS10F8,$Cret00BPTCTRBNS10F10,$Cret00BPTCTRBNS10F12,
    $Cret00BPTCTRBNS10F14,$Cret00BPTCTRBNS10F16,$Cret00BPTCTRBNS10F18,$Cret00BPTCTRBNS10F20,
    $Cret00BPTCTRBNS10F22,$Cret00BPTCTRBNS10F24,$Cret00BPTCTRBNS10F26,$Cret00BPTCTRBNS10F28));

  if(TaxMathUtils.compareTo($Cret00BPTCTRBNS10F29.needValue,TaxMathUtils.sum("0")) < 0){
    $Cret00BPTCTRBNS10F29.setCalValue(TaxMathUtils.sum("0"));
  }

  assResult.compareAndSet($Cret00BPTCTRBNS10F29);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F30_TO_31"
    when
  $Cret00TaxtypeCode:TaxField(fieldName == "Cret00TaxtypeCode");
  $Cret00RetTaxperiod:TaxField(fieldName == "Cret00RetTaxperiod");
  $Cret00BPTTaxpayerUid:TaxField(fieldName == "Cret00BPTTaxpayerUid");
  $Cret00BPTVerTaxyear:TaxField(fieldName == "Cret00BPTVerTaxyear");
  
  $Cret00BPTCTRBNS10F29:TaxField(fieldName == "Cret00BPTCTRBNS10F29");
  $Cret00BPTCTRBNS10F30:TaxField(fieldName == "Cret00BPTCTRBNS10F30",calValue==null);
  $Cret00BPTCTRBNS10F31:TaxField(fieldName == "Cret00BPTCTRBNS10F31",calValue==null);
    then
  String val = TaxValidation.getMinusThePrepaidTax($Cret00BPTTaxpayerUid,$Cret00RetTaxperiod,$Cret00TaxtypeCode,$Cret00BPTVerTaxyear);
  String s10f30 = String.valueOf(0);
  if(TaxMathUtils.isNotNull(val)){
    s10f30 = val;
  }
  $Cret00BPTCTRBNS10F30.setCalValue(TaxMathUtils.sum(s10f30));
  assResult.compareAndSet($Cret00BPTCTRBNS10F30);

  //S10F31 = S10F29 - S10F30
  $Cret00BPTCTRBNS10F31.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS10F29,$Cret00BPTCTRBNS10F30));
  
  if(TaxMathUtils.compareTo($Cret00BPTCTRBNS10F31.needValue,TaxMathUtils.sum("0")) < 0){
    $Cret00BPTCTRBNS10F31.setCalValue(TaxMathUtils.sum("0"));
  }

  assResult.compareAndSet($Cret00BPTCTRBNS10F31);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F32_TO_33"
    when
  $Cret00BPTCTRBNS2F20:TaxField(fieldName == "Cret00BPTCTRBNS2F20");
  $Cret00BPTCTRBNS4F31:TaxField(fieldName == "Cret00BPTCTRBNS4F31");
  $Cret00BPTCTRBNS6F12:TaxField(fieldName == "Cret00BPTCTRBNS6F12");
  
  $Cret00BPTCTRBNS10F32:TaxField(fieldName == "Cret00BPTCTRBNS10F32",calValue==null);
  $Cret00BPTCTRBNS10F33:TaxField(fieldName == "Cret00BPTCTRBNS10F33",calValue==null);
    then
  //S10F32 = S2F20+S4F31+S6F12
  $Cret00BPTCTRBNS10F32.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F20,$Cret00BPTCTRBNS4F31,$Cret00BPTCTRBNS6F12));
  assResult.compareAndSet($Cret00BPTCTRBNS10F32);

  //S10F33 = S10F32 * 7%
  //$Cret00BPTCTRBNS10F33.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F32.needValue,"0.07"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F32.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F32.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F33.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F32.getNeedValue(),"0.07"));
  }else{
  $Cret00BPTCTRBNS10F33.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F33);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F34_TO_35"
    when
  $Cret00BPTCTRBNS4F14:TaxField(fieldName == "Cret00BPTCTRBNS4F14");
  $Cret00BPTCTRBNS4F20:TaxField(fieldName == "Cret00BPTCTRBNS4F20");
  $Cret00BPTCTRBNS6F3:TaxField(fieldName == "Cret00BPTCTRBNS6F3");
    
  $Cret00BPTCTRBNS10F34:TaxField(fieldName == "Cret00BPTCTRBNS10F34",calValue==null);
  $Cret00BPTCTRBNS10F35:TaxField(fieldName == "Cret00BPTCTRBNS10F35",calValue==null);
    then
  //S10F34 = S4F14+S4F20+S6F3
  $Cret00BPTCTRBNS10F34.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS4F14,$Cret00BPTCTRBNS4F20,$Cret00BPTCTRBNS6F3));
  assResult.compareAndSet($Cret00BPTCTRBNS10F34);
  
  //S10F35 = S10F34 * 7%
  //$Cret00BPTCTRBNS10F35.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F34.needValue,"0.07"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F34.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F34.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F35.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F34.getNeedValue(),"0.07"));
  }else{
  $Cret00BPTCTRBNS10F35.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F35);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F36_TO_37"
    when
  $Cret00BPTCTRBNS2F21:TaxField(fieldName == "Cret00BPTCTRBNS2F21");
  $Cret00BPTCTRBNS4F32:TaxField(fieldName == "Cret00BPTCTRBNS4F32");
  $Cret00BPTCTRBNS6F13:TaxField(fieldName == "Cret00BPTCTRBNS6F13");

  $Cret00BPTCTRBNS10F36:TaxField(fieldName == "Cret00BPTCTRBNS10F36",calValue==null);
  $Cret00BPTCTRBNS10F37:TaxField(fieldName == "Cret00BPTCTRBNS10F37",calValue==null);
    then
  //S10F36 = S2F21+S4F32+S6F13
  $Cret00BPTCTRBNS10F36.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F21,$Cret00BPTCTRBNS4F32,$Cret00BPTCTRBNS6F13));
  assResult.compareAndSet($Cret00BPTCTRBNS10F36);
  
  //S10F37 = S10F36 * 7%
  //$Cret00BPTCTRBNS10F37.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F36.needValue,"0.07"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F36.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F36.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F37.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F36.getNeedValue(),"0.07"));
  }else{
  $Cret00BPTCTRBNS10F37.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F37);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F38_TO_39"
    when
  $Cret00BPTCTRBNS2F22:TaxField(fieldName == "Cret00BPTCTRBNS2F22");
  $Cret00BPTCTRBNS4F33:TaxField(fieldName == "Cret00BPTCTRBNS4F33");
  $Cret00BPTCTRBNS6F14:TaxField(fieldName == "Cret00BPTCTRBNS6F14");
    
  $Cret00BPTCTRBNS10F38:TaxField(fieldName == "Cret00BPTCTRBNS10F38",calValue==null);
  $Cret00BPTCTRBNS10F39:TaxField(fieldName == "Cret00BPTCTRBNS10F39",calValue==null);
    then
  //S10F38 = S2F22+S4F33+S6F14
  $Cret00BPTCTRBNS10F38.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS2F22,$Cret00BPTCTRBNS4F33,$Cret00BPTCTRBNS6F14));
  assResult.compareAndSet($Cret00BPTCTRBNS10F38);
  
  //S10F39 = S10F38 * 7%
  //$Cret00BPTCTRBNS10F39.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F38.needValue,"0.07"));
  if(TaxMathUtils.isNotNull($Cret00BPTCTRBNS10F38.getNeedValue())&&TaxMathUtils.compareTo($Cret00BPTCTRBNS10F38.getNeedValue(),TaxMathUtils.sum("0")) > 0){
  $Cret00BPTCTRBNS10F39.setCalValue(TaxMathUtils.mulitplyTax($Cret00BPTCTRBNS10F38.getNeedValue(),"0.07"));
  }else{
  $Cret00BPTCTRBNS10F39.setCalValue(TaxMathUtils.sum("0"));
  }
  assResult.compareAndSet($Cret00BPTCTRBNS10F39);
end

//Schedule 10 : Calculation of Tax Payable
rule "calc_S10_Cret00BPTCTRBNS10F40"
    when
  $Cret00BPTCTRBNS10F31:TaxField(fieldName == "Cret00BPTCTRBNS10F31");
  $Cret00BPTCTRBNS10F33:TaxField(fieldName == "Cret00BPTCTRBNS10F33");
  $Cret00BPTCTRBNS10F35:TaxField(fieldName == "Cret00BPTCTRBNS10F35");
  $Cret00BPTCTRBNS10F37:TaxField(fieldName == "Cret00BPTCTRBNS10F37");
  $Cret00BPTCTRBNS10F39:TaxField(fieldName == "Cret00BPTCTRBNS10F39");
 
  $Cret00BPTCTRBNS10F40:TaxField(fieldName == "Cret00BPTCTRBNS10F40",calValue==null);
    then
  //S10F40=S10F31+S10F33+S10F35+S10F37+S10F39
  $Cret00BPTCTRBNS10F40.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS10F31,$Cret00BPTCTRBNS10F33,$Cret00BPTCTRBNS10F35,
    $Cret00BPTCTRBNS10F37,$Cret00BPTCTRBNS10F39));
   assResult.compareAndSet($Cret00BPTCTRBNS10F40);
end
//----------Schedule 10: end----------------------------

//----------Schedule 11: start--------------------------
//Schedule 11 : Complementary Data to The Return [1: S11F8=S11F5+S11F6+S11F7 and S11F9=totals of S11F8]
rule "calc_S11_Cret00BPTCTRBNS11F8_S11F9"
    when 
        $Cret00BPTCTRBNS11F5:TaxField(fieldName == "Cret00BPTCTRBNS11F5",cal==false);
        $Cret00BPTCTRBNS11F6:TaxField(fieldName == "Cret00BPTCTRBNS11F6",rowNum==$Cret00BPTCTRBNS11F5.rowNum);
  $Cret00BPTCTRBNS11F7:TaxField(fieldName == "Cret00BPTCTRBNS11F7",rowNum==$Cret00BPTCTRBNS11F5.rowNum);
  $Cret00BPTCTRBNS11F8:TaxField(fieldName == "Cret00BPTCTRBNS11F8",rowNum==$Cret00BPTCTRBNS11F5.rowNum);
        $Cret00BPTCTRBNS11F9:TaxField(fieldName == "Cret00BPTCTRBNS11F9");            
    then
  //S11F8=S11F5+S11F6+S11F7
  $Cret00BPTCTRBNS11F8.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS11F5,$Cret00BPTCTRBNS11F6,$Cret00BPTCTRBNS11F7));
  assResult.compareAndSet($Cret00BPTCTRBNS11F8);
  //update($Cret00BPTCTRBNS11F8);
  
  //S11F9=totals of S11F8
        $Cret00BPTCTRBNS11F9.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F9.getCalValue(),$Cret00BPTCTRBNS11F8.getCalValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS11F9);
  //update($Cret00BPTCTRBNS11F9);
  
  $Cret00BPTCTRBNS11F5.setCal(true);
end

rule "calc_S11_Cret00BPTCTRBNS11F9_EQUAL"
    when 
  $Cret00BPTCTRBNS11F9:TaxField(fieldName == "Cret00BPTCTRBNS11F9");   
  $Cret00BPTCTRBNS11F10:TaxField(fieldName == "Cret00BPTCTRBNS11F10",calValue==null);
  $Cret00BPTCTRBNS11F11:TaxField(fieldName == "Cret00BPTCTRBNS11F11",calValue==null);
  $Cret00BPTCTRBNS11F12:TaxField(fieldName == "Cret00BPTCTRBNS11F12",calValue==null);
    then
  assResult.compareAndSet($Cret00BPTCTRBNS11F9);
  //Should be equal as (S11F10+S11F11+S11F12), if not, return will workflow to Data Entry Supervisor with message 'Distribution of amount of rent paid needs manual adjustment.'
  String msg = "com.cacss.itas.ret.bpt.rent.paid.needs.manual.adjustment";
  String s11f9FieldName_p = "com.cacss.itas.ret.returnBPTCTRBN.S11F9";
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS11F10,$Cret00BPTCTRBNS11F11,$Cret00BPTCTRBNS11F12);
  if(TaxMathUtils.compareTo(sumV, $Cret00BPTCTRBNS11F9.getNeedValue()) != 0) {
    assResult.addMandatoryFields("calc_S11_Cret00BPTCTRBNS11F9_EQUAL", msg+"@"+s11f9FieldName_p+"@"+$Cret00BPTCTRBNS11F9.getNeedValue());
  }
end

//Schedule 11 : Complementary Data to The Return [2: S11F20=S11F17-S11F18-S11F19 and S11F21=totals of S11F20]
rule "calc_S11_Cret00BPTCTRBNS11F20_S12F21"
    when 
        $Cret00BPTCTRBNS11F17:TaxField(fieldName == "Cret00BPTCTRBNS11F17",cal==false);
        $Cret00BPTCTRBNS11F18:TaxField(fieldName == "Cret00BPTCTRBNS11F18",rowNum==$Cret00BPTCTRBNS11F17.rowNum);
  $Cret00BPTCTRBNS11F19:TaxField(fieldName == "Cret00BPTCTRBNS11F19",rowNum==$Cret00BPTCTRBNS11F17.rowNum);
  $Cret00BPTCTRBNS11F20:TaxField(fieldName == "Cret00BPTCTRBNS11F20",rowNum==$Cret00BPTCTRBNS11F17.rowNum);
        $Cret00BPTCTRBNS11F21:TaxField(fieldName == "Cret00BPTCTRBNS11F21");            
    then
  //S11F20=S11F17-S11F18-S11F19
  $Cret00BPTCTRBNS11F20.setCalValue(TaxMathUtils.subTaxOriginal($Cret00BPTCTRBNS11F17,$Cret00BPTCTRBNS11F18,$Cret00BPTCTRBNS11F19));
  assResult.compareAndSet($Cret00BPTCTRBNS11F20);
  //update($Cret00BPTCTRBNS11F20);
  
  //S11F21=totals of S11F20
        $Cret00BPTCTRBNS11F21.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F21.getCalValue(),$Cret00BPTCTRBNS11F20.getCalValue()));
  //assResult.compareAndSet($Cret00BPTCTRBNS11F21);
  //update($Cret00BPTCTRBNS11F21);
  
  $Cret00BPTCTRBNS11F17.setCal(true);
end

rule "calc_S11_Cret00BPTCTRBNS11F21_EQUAL"
    when  
  $Cret00BPTCTRBNS11F21:TaxField(fieldName == "Cret00BPTCTRBNS11F21");   
  $Cret00BPTCTRBNS11F22:TaxField(fieldName == "Cret00BPTCTRBNS11F22",calValue==null);
  $Cret00BPTCTRBNS11F23:TaxField(fieldName == "Cret00BPTCTRBNS11F23",calValue==null);
  $Cret00BPTCTRBNS11F24:TaxField(fieldName == "Cret00BPTCTRBNS11F24",calValue==null);
    then
  assResult.compareAndSet($Cret00BPTCTRBNS11F21);
  //Should be equal as (S11F22+S11F23+S11F24), if not, return will workflow to Data Entry Supervisor with message 'Distribution of amount of rent received needs manual adjustment.'
  String msg = "com.cacss.itas.ret.bpt.rent.received.needs.manual.adjustment";
  String s11f21FieldName_p = "com.cacss.itas.ret.returnBPTCTRBN.S11F21";
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS11F22,$Cret00BPTCTRBNS11F23,$Cret00BPTCTRBNS11F24);
  if(TaxMathUtils.compareTo(sumV, $Cret00BPTCTRBNS11F21.getNeedValue()) != 0) {
    assResult.addMandatoryFields("calc_S11_Cret00BPTCTRBNS11F21_EQUAL", msg+"@"+s11f21FieldName_p+"@"+$Cret00BPTCTRBNS11F21.getNeedValue());
  }
end

//Schedule 11 : Complementary Data to The Return [3: S11F30=totals of S11F29]
rule "calc_S11_Cret00BPTCTRBNS11F30"
    when 
        $Cret00BPTCTRBNS11F29:TaxField(fieldName == "Cret00BPTCTRBNS11F29",cal==false);
        $Cret00BPTCTRBNS11F30:TaxField(fieldName == "Cret00BPTCTRBNS11F30");            
    then
  // S12F30=totals of S12F29
        $Cret00BPTCTRBNS11F30.setCalValue(TaxMathUtils.sum($Cret00BPTCTRBNS11F30.getCalValue(),$Cret00BPTCTRBNS11F29.getNeedValue()));
   //assResult.compareAndSet($Cret00BPTCTRBNS11F30);
  //update($Cret00BPTCTRBNS11F30);
  
  $Cret00BPTCTRBNS11F29.setCal(true);
end

rule "calc_S11_Cret00BPTCTRBNS11F30_EQUAL"
    when  
  $Cret00BPTCTRBNS11F30:TaxField(fieldName == "Cret00BPTCTRBNS11F30");   
  $Cret00BPTCTRBNS11F31:TaxField(fieldName == "Cret00BPTCTRBNS11F31",calValue==null);
  $Cret00BPTCTRBNS11F32:TaxField(fieldName == "Cret00BPTCTRBNS11F32",calValue==null);
  $Cret00BPTCTRBNS11F33:TaxField(fieldName == "Cret00BPTCTRBNS11F33",calValue==null);
    then
  assResult.compareAndSet($Cret00BPTCTRBNS11F30);
  //Should be equal as (S11F31+S11F32+S11F33), if not, return will workflow to Data Entry Supervisor with message 'Distribution of The shares in affiliates and other companies needs manual adjustment.'
  String msg = "com.cacss.itas.ret.bpt.affiliates.and.companies.needs.manual.adjustment"; 
  String s11f30FieldName_p = "com.cacss.itas.ret.returnBPTCTRBN.S11F30";
  String sumV = TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS11F31,$Cret00BPTCTRBNS11F32,$Cret00BPTCTRBNS11F33);
  if(TaxMathUtils.compareTo(sumV, $Cret00BPTCTRBNS11F30.getNeedValue()) != 0) {
    assResult.addMandatoryFields("calc_S11_Cret00BPTCTRBNS11F30_EQUAL", msg+"@"+s11f30FieldName_p+"@"+$Cret00BPTCTRBNS11F30.getNeedValue());
  }
end
//----------Schedule 11: end----------------------------

//---------Return: Tax Due and Tax Payable: START--------------
rule "calc_Return_TaxDue_TaxPayable"
    when 
  $Cret00BPTTaxDue:TaxField(fieldName == "Cret00BPTTaxDue",calValue==null);
  $Cret00BPTCTRBNS10F29:TaxField(fieldName == "Cret00BPTCTRBNS10F29");  
  $Cret00BPTCTRBNS10F33:TaxField(fieldName == "Cret00BPTCTRBNS10F33");
  $Cret00BPTCTRBNS10F35:TaxField(fieldName == "Cret00BPTCTRBNS10F35");  
  $Cret00BPTCTRBNS10F37:TaxField(fieldName == "Cret00BPTCTRBNS10F37");
  $Cret00BPTCTRBNS10F39:TaxField(fieldName == "Cret00BPTCTRBNS10F39");  
  $Cret00BPTCTRBNS10F40:TaxField(fieldName == "Cret00BPTCTRBNS10F40");
    then
  // Tax Due = S10F29+S10F33+S10F35+S10F37+S10F39
  $Cret00BPTTaxDue.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS10F29, $Cret00BPTCTRBNS10F33, 
          $Cret00BPTCTRBNS10F35, $Cret00BPTCTRBNS10F37, $Cret00BPTCTRBNS10F39));
  //assResult.compareAndSet($Cret00BPTTaxDue);
  //update($Cret00BPTTaxDue);

  // Tax Payable = S10F40
  $Cret00BPTCTRBNS10F40.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00BPTCTRBNS10F40));
  assResult.compareAndSet($Cret00BPTCTRBNS10F40);
  //update($Cret00BPTCTRBNS10F40);

  assResult.setPayableName($Cret00BPTCTRBNS10F40.fieldName);
  assResult.setPayable($Cret00BPTCTRBNS10F40.calValue);
  assResult.setTaxDueName($Cret00BPTTaxDue.fieldName);
  assResult.setTaxDue($Cret00BPTTaxDue.calValue);
  
  //System.out.println(calcCommercialRate("10000"));
  //System.out.println(calcIndustrialRate("5000"));
end
//---------Return: Tax Due and Tax Payable: END--------------