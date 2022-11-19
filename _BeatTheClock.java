package com.thaidrills.apps.BeatTheClock;
/********************************************************************
* @(#)_BeatTheClock.java 1.00 20110826
* Copyright (c) 2010-2011 by Richard T. Salamone, Jr. All rights reserved.
*
* _BeatTheClock: The main container frame for the Beat The Clock desktop
* application.
*
* @author Rick Salamone
* @version 1.01 20110826 rts Beat the Clock Stand Alone Desktop App
*******************************************************/
import com.thaidrills.modules.btc.BeatTheClock;
import com.shanebow.ui.menu.*;
import com.shanebow.ui.LAF;
import com.shanebow.util.SBProperties;
import java.awt.*;
import javax.swing.*;

public class _BeatTheClock
	extends JFrame
	{
	private static long blowUp = com.shanebow.util.SBDate.toTime("20151121  23:59");

	public static void main(String[] args)
		{
try
{
		SBProperties.load(_BeatTheClock.class, "com/thaidrills/resources/thai.properties");
		LAF.init(blowUp);
		new _BeatTheClock();
}
catch(Throwable e) { e.printStackTrace(); System.exit(1); }
		}

	public _BeatTheClock()
		{
		SBProperties props = SBProperties.getInstance();
		setTitle(props.getProperty("app.name")
		        + " " + props.getProperty("app.version"));
		setBounds(props.getRectangle("usr.app.bounds", 50,50,640,640)); // x,y,w,h
		buildContent();
		buildMenus();
		setVisible(true);
		}

	private void buildContent()
		{
		getContentPane().add(new BeatTheClock(), java.awt.BorderLayout.CENTER);
		}

	private void buildMenus()
		{
		SBMenuBar menuBar = new SBMenuBar();
		menuBar.addMenu("File",
			LAF.setExitAction(new com.shanebow.ui.SBExitAction(this)
				{
				public void doApplicationCleanup() {}
				})
			);
		menuBar.addMenu("Themes",
			menuBar.getThemeMenu()
			);
		menuBar.addMenu("Help",
			new SBAboutAction(this)
			);
		setJMenuBar(menuBar);
		}
	}
