<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%> 
<%@page import=" domain.Book"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
		<h3 class="text-muted text-center  p-2">Book List</h3>

      <div class="row mb-2">
         <div class="col-md-12">
            <form action="./Home" class="form-inline" method="post">
               <div class="form-group mb-2">
                  <input type="text" placeholder="Book Name" name="book-name" required class="form-control">
               </div>
               <div class="form-group mx-sm-3 mb-2">
                  <input type="text" placeholder="Author Name" name="author-name" required class="form-control">
               </div>
               <button class="btn btn-success mb-2" name="addbook" type="submit">
                  Add Books
               </button>

            </form>
         </div>
      </div>

      <div class="table-responsive">
         <table class="table table-bordered table-hover">
            <thead class="thead-dark">
               <tr>
                  <th scope="col">#</th>
                  <th scope="col">Book Name</th>
                  <th scope="col">Author Name</th>
                  <th scope="col">Operations</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${books}" var="book">
                  <tr>
                     <th scope="row">${book.index}</th>
                     <td>${book.name}</td>
                     <td>${book.author}</td>
                     <td>
                     	<div class="d-flex flex-row">
                     	<form action="./Home" method="post">
                           <input type="hidden" name="bookid" value="${book.book_id}">
                           <button class="btn btn-danger mr-2" type="submit" name="deletebook">Delete</button>
                        </form>
                        <a class="btn btn-info" href="./EditBook?itemid=${book.book_id}">Edit</a>
                     	</div>
                     	
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>
	
	
	
	
</body>
</html>