<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<div class="container">
      <div class="card">
         <div class="card-header text-center">
            <strong>Edit Book</strong>
         </div>
         <div class="card-body">
            <form action="./EditBook" class="form-group" method="post">
    
               <input type="hidden" name="bookid" value="${book.book_id}">
               <div class="form-group mb-2">
                  <label for="bookname"><strong>Book Name</strong></label>
                  <input type="text" id="bookname" value="${book.name}" name="bookname" required class="form-control">
               </div>
               <div class="form-group mb-2">
                  <label for="authorname"><strong>Author Name</strong></label>
                  <input type="text" required value="${book.author}" name ="authorname" class="form-control">
               </div>
               <button class="btn btn-success" type="submit">
                  Update Books
               </button>

            </form>
         </div>
      </div>
   </div>
</body>
</html>