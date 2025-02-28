package com.manske.sistemaDeNotas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGradesRelations {
	private Student studentBadArg, studentReprovatedGrades, studentBadGrades, studentRegularGrades, studentGoodGrades, studentExcelentGrades;

	/* Basically a constructor for the members */
	@BeforeEach public void init()
	{
		System.out.println("testGradesRelations::init(): Initializing students...");

		this.studentBadArg           = new Student(null,         122.f);
		this.studentReprovatedGrades = new Student("Ariel 1", 29.9f);
		this.studentBadGrades        = new Student("Ariel 2", 49.9f);
		this.studentRegularGrades    = new Student("Ariel 3", 74.9f);
		this.studentGoodGrades       = new Student("Ariel 4", 89.9f);
		this.studentExcelentGrades   = new Student("Arthur", 100.0f);
		
		System.out.println("testGradesRelations::init(): Successfully initialized students!");
	}

	@Test public void testBadArgs()
	{
		System.out.println("testGradesRelations::testBadArg(): Testing bad argument student...");
		assertEquals(null, GradesRelations.evaluate(this.studentBadArg), "Expected result to be null.");
		System.out.println("testGradesRelations::testBadArg(): Successfully performed tests!");
	}
	
	@Test public void testReprovatedGrades()
	{
		System.out.println("testGradesRelations::testBadGrades(): Testing reprovated grades student...");
		assertEquals("Reprovado!", GradesRelations.evaluate(this.studentReprovatedGrades), "Expected result to be reprovated.");
		System.out.println("testGradesRelations::testRegularGrades(): Successfully performed tests!");
	}
	
	@Test public void testBadGrades()
	{
		System.out.println("testGradesRelations::testBadGrades(): Testing bad grades student...");
		assertEquals("Precisa de recuperação.", GradesRelations.evaluate(this.studentBadGrades), "Expected result to be need recover.");
		System.out.println("testGradesRelations::testRegularGrades(): Successfully performed tests!");
	}

	@Test public void testRegularGrades()
	{
		System.out.println("testGradesRelations::testRegularGrades(): Testing regular grades student...");
		assertEquals("Desempenho mediano.", GradesRelations.evaluate(this.studentRegularGrades), "Expected result to be avarage.");
		System.out.println("testGradesRelations::testRegularGrades(): Successfully performed tests!");
	}

	@Test public void testGoodGrades()
	{
		System.out.println("testGradesRelations::testGoodGrades(): Testing good grades student...");
		assertEquals("Desempenho bom.", GradesRelations.evaluate(this.studentGoodGrades), "Expected result to be good.");
		System.out.println("testGradesRelations::testGoodGrades(): Successfully performed tests!");
	}
	
	@Test public void testExcelentGrades()
	{
		System.out.println("testGradesRelations::testExcelentGrades(): Testing good grades student...");
		assertEquals("Desempenho excelente!", GradesRelations.evaluate(this.studentExcelentGrades), "Expected result to be excelent.");
		System.out.println("testGradesRelations::testExcelentGrades(): Successfully performed tests!");
	}
};
