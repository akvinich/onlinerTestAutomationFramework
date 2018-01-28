package attd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractAnalysisPage extends AbstractPage{

    protected String tableProductClassName = "product-specs__table";

    protected List<WebElement> mainList = null;

    protected String regNumberWithDot = "((\\d+)(\\.?)(\\d+)|(\\d+))";
    protected String regDividerMinus = "(\\–)";
    protected String regDividerX ="x";
    protected String regDividerComma = ",";

    public AbstractAnalysisPage(WebDriver driver) {
        super(driver);
    }

    private WebElement findCell(List<WebElement> list, String text){
        WebElement element = null;
        for(int i=0; i<list.size(); i++){
            if (list.get(i).getText().trim().equals(text)){
                element = list.get(i);
            }
        }
        return element;
    }

    private WebElement findParentElementTr(WebElement element){
        return element.findElement(By.xpath("ancestor::tr[1]"));
    }

    private WebElement findNeedTd(WebElement element){
        return element.findElement(By.xpath("descendant::td[2]"));
    }

    protected WebElement findNeedElementByText(String text){
        return findNeedTd(findParentElementTr(findCell(mainList,text)));
    }

    protected Double[] convertArrayStringToDouble(String[] arrayString){
        Double[] doubleArray = new Double[arrayString.length];
        for (int i=0; i<arrayString.length; i++){
            doubleArray[i] = Double.parseDouble(arrayString[i]);
        }
        return  doubleArray;
    }

    protected Integer[] convertArrayStringToInt(String[] arrayString){
        Integer[] integerArray = null;
        for (int i=0; i<arrayString.length; i++){
            integerArray[i] = Integer.parseInt(arrayString[i]);
        }
        return integerArray;
    }

    protected String[] findAndSplitString(String strForSplit, String regNumber, String regDivider){
        String[] resultMass = new String[2];
        Pattern p1 = Pattern.compile(regNumber+regDivider+regNumber);
        Matcher m1 = p1.matcher(strForSplit);
        m1.find();
        resultMass = m1.group().split(regDivider);
        return resultMass;
    }

    protected String findInString(String strForSearchNumber, String reg){
        Pattern p1 = Pattern.compile(reg);
        Matcher m1 = p1.matcher(strForSearchNumber);
        m1.find();
        return m1.group();
    }

    protected String[] splitString(String strForSearch, String regDivider) {
        return strForSearch.split(regDivider);
    }

    protected String getYesOrNo(WebElement element){
        element = element.findElement(By.xpath("descendant::span[1]"));
        StringBuilder s = new StringBuilder("");
        switch (element.getAttribute("class")){
            case "i-tip":
                s = new StringBuilder("ДА");
                break;
            case "i-x":
                s = new StringBuilder("НЕТ");
                break;
            default:
                s = new StringBuilder("Exception");
        }
        return  s.toString();
    }

}
