package chat.theme;

import javax.swing.LookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Themes {
	// 다크모드 있는거
	public LookAndFeel FlatLightLaf;
	public LookAndFeel FlatDarkLaf;
	public LookAndFeel FlatMacLightLaf;
	public LookAndFeel FlatMacDarkLaf;
	public LookAndFeel FlatArcIJTheme;
	public LookAndFeel FlatArcDarkIJTheme;
	public LookAndFeel FlatArcOrangeIJTheme;
	public LookAndFeel FlatArcDarkOrangeIJTheme;
	
	// 다크모드 없는거
	public LookAndFeel FlatDarculaLaf;
	public LookAndFeel FlatIntelliJLaf;
	public LookAndFeel FlatCyanLightIJTheme;
	public LookAndFeel FlatDarkPurpleIJTheme;
	public LookAndFeel FlatCarbonIJTheme;
	public LookAndFeel DefaultTheme;
	
	public Themes( ){
		// 다크모드 있는거
		FlatLightLaf = new FlatLightLaf();
		FlatDarkLaf = new FlatDarkLaf();
		FlatDarculaLaf = new FlatDarculaLaf();
		FlatMacLightLaf = new FlatMacLightLaf();
		FlatMacDarkLaf = new FlatMacDarkLaf();
		FlatArcIJTheme = new FlatArcIJTheme();
		FlatArcDarkIJTheme = new FlatArcDarkIJTheme();
		FlatArcOrangeIJTheme = new FlatArcOrangeIJTheme();
		FlatArcDarkOrangeIJTheme = new FlatArcDarkOrangeIJTheme();
		
		// 다크모드 없는거
		FlatDarculaLaf = new FlatDarculaLaf();
		FlatIntelliJLaf = new FlatIntelliJLaf();
		FlatCyanLightIJTheme = new FlatCyanLightIJTheme();
		FlatDarkPurpleIJTheme = new FlatDarkPurpleIJTheme();
		FlatCarbonIJTheme = new FlatCarbonIJTheme();
		
		// 기본테마
		DefaultTheme = new MetalLookAndFeel();
	}
	
	// 다크모드 <-> 기본모드
	public LookAndFeel getNegative(LookAndFeel theme) {
	    if (theme instanceof FlatLightLaf) {
	        return FlatDarkLaf;
	    } else if (theme instanceof FlatDarkLaf) {
	        return FlatLightLaf;
	    } else if (theme instanceof FlatMacLightLaf) {
	        return FlatMacDarkLaf;
	    } else if (theme instanceof FlatMacDarkLaf) {
	        return FlatMacLightLaf;
	    } else if (theme instanceof FlatArcIJTheme) {
	        return FlatArcDarkIJTheme;
	    } else if (theme instanceof FlatArcDarkIJTheme) {
	        return FlatArcIJTheme;
	    } else if (theme instanceof FlatArcOrangeIJTheme) {
	        return FlatArcDarkOrangeIJTheme;
	    } else if (theme instanceof FlatArcDarkOrangeIJTheme) {
	        return FlatArcOrangeIJTheme;
	    }

	    return null;
	}

}
