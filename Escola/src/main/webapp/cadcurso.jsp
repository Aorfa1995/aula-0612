<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="cep.js" type="text/javascript"></script>

</head>
<body>

<div class="container">

	<div class="row">
		<div class="col-md-12 text-center">
		<h3>Controle de Cursos</h3>
		</div>
	</div>
  
  <form method="get" action="novocurso">
 
  <div class="form-row">
    <div class="col-md-2 mb-3">
    <label for="idcurso">Código do Curso</label>
    <input type="text" class="form-control" name="idcurso">   
   </div>
  
   <div class="col-md-6 mb-3">
    <label for="nome">Nome do Curso</label>
    <input type="text" class="form-control" id="" placeholder="Digite Nome do curso" name="nome">
  </div>
  
   <div class="col-md-2 mb-3">
    <label for="cargahoraria">carga Horaria</label>
    <input type="text" class="form-control" id="" placeholder="Digite a carga horaria" name="cargahoraria">
  </div>
  
    
  <div class="form-row">
    <div class="col-md-6 mb-3">
    <label for="tipocurso">Tipo do Curso</label>
    <input type="text" class="form-control" id="" placeholder="Digite o tipo de curso" name="tipocurso">
  </div>
  
   
  
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>



</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
