package com.manske.sistemaDeNotas;

public class Student {
	private boolean gradesSet = false;

	private String name;
	private float  grades;

	public Student(String name) { this.name = name; }
	
	public Student(String name, float grades)
	{
		this(name);
		this.setGrades(grades);
	}

	public boolean isGradesSet()
	{
		return this.gradesSet;
	}

	public boolean setGrades(float grades)
	{
		if (grades > 100.f || grades < 0.f) {
			this.gradesSet = false;
			return false;
		}

		this.grades = grades;
		this.gradesSet = true;

		return true;
	}

	public float getGrades()
	{
		if (!this.isGradesSet()) return 0.f;
		return this.grades;
	}

	public String getName() { return this.name; }
};
