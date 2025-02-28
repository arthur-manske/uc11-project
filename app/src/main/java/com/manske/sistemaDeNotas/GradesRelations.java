package com.manske.sistemaDeNotas;

public class GradesRelations {
	public static String evaluate(Student student)
	{
		final var grades = student.getGrades();
		if (!student.isGradesSet()) return null;

		if (grades < 30.0f)   return "Reprovado!";
		if (grades < 50.0f)   return "Precisa de recuperação.";
		if (grades < 75.0f)   return "Desempenho mediano.";
		if (grades < 90.0f)   return "Desempenho bom.";
		if (grades <= 100.0f) return "Desempenho excelente!";

		return null;
	}
};
