package com.example.assignment;

import android.app.Application;

public class MyApp extends Application {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		setName("Grace");
	}
	

}
