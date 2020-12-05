package harujisaku.minicode.highlight;

import java.awt.Color;

public class JavaHighlight extends AbstractHighlight {
	String WHITE_SPACE_REGEX = "[ /\\\\(\\)\"':,.;~\\!@#$%\\^\\[\\]\\{\\}`\\?\\-…\\t]";
	String [] MAGENTA_KEYWORDS = {"abstract","assert","break","case","catch","class","const","continue","default","do","else","enum","extends","final","finally","for","goto","if","implements","import","instanceof","native","new","package","private","private","public","return","static","strictfp","switch","synchronized","throw","ththrows","transient","try","void","volatile","while","\\|","\\|\\|","\\&","=","\\>","\\<","==",">=","<=","&&"};
	String[] CYAN_KEYWORDS = {WHITE_SPACE_REGEX+"+[a-z]+[a-zA-Z0-9]+\\("};
	String[] YELLOW_KEYWORDS = {WHITE_SPACE_REGEX+"([A-Z]{1,2}[a-z][a-zA-Z0-9]+|int|char|boolean|void|Override|override)(?="+WHITE_SPACE_REGEX+")(?!\\()"};
	String[] GREEN_KEYWORDS = {"\".*\""};
	String[] ORANGE_KEYWORDS = {"([A-Z]+[A-Z_]|null|true|false"+WHITE_SPACE_REGEX+"[0-9]+"+WHITE_SPACE_REGEX+")"};
	String[] RED_KEYWORDS = {WHITE_SPACE_REGEX+"(super|this)"+WHITE_SPACE_REGEX};
	public JavaHighlight(){
		super.MAGENTA_KEYWORDS=this.MAGENTA_KEYWORDS;
		super.CYAN_KEYWORDS=this.CYAN_KEYWORDS;
		super.YELLOW_KEYWORDS=this.YELLOW_KEYWORDS;
		super.GREEN_KEYWORDS=this.GREEN_KEYWORDS;
		super.ORANGE_KEYWORDS=this.ORANGE_KEYWORDS;
		super.RED_KEYWORDS=this.RED_KEYWORDS;
		super.WHITE_SPACE_REGEX=this.WHITE_SPACE_REGEX;
	}
	
	@Override
	public Color quotation(){
		return Color.GREEN;
	}
}