package br.edu.infnet.silvioluizbassi.Dtos.requests;

public record MatriculaRequest(long numeroMatricula, AlunoRequestId aluno, CursoRequestId curso) { }
