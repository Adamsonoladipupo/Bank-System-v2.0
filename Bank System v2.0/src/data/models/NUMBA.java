package data.models;

public class NUMBA {
    private int accountSerialNumber;
    private int bankCode;
    private int[] weightingNumber = {3,7,3,3,7,3,3,7,3};

    public NUMBA (int bankCode, int serialNumber){
        this.accountSerialNumber = serialNumber;
        this.bankCode = bankCode;
    }

    public String getNumba(){
        return generateAccountNumber();
    }

    private String generateCheckNumber(){
        int[] array = new int[9];
        String bankCodeAndAccountSerialNumber = String.valueOf(this.bankCode) + String.valueOf(this.accountSerialNumber);
        for (int insert = 0; insert < array.length; insert++){
            char number = bankCodeAndAccountSerialNumber.charAt(insert);
            array[insert] = (int)number - '0';
        }
        // multiplying the bank code and the account serial number with the CBN weighting number
        int multipliedNumbers = 0; int SumAllMultipliedNumbers = 0;
        for (int multiply = 0; multiply < array.length; multiply++){
            multipliedNumbers = weightingNumber[multiply] * array[multiply];
            SumAllMultipliedNumbers += multipliedNumbers;
        }
        int module10 = SumAllMultipliedNumbers % 10;
        int checkNumber = 10 - module10;
        return String.valueOf(checkNumber);
    }

    private String generateAccountNumber(){
        String bankCode = String.valueOf(this.bankCode);
        String accountSerialNumber = String.valueOf(this.accountSerialNumber);
        String checkNumber = generateCheckNumber();
        return bankCode + accountSerialNumber + checkNumber;
    }

}