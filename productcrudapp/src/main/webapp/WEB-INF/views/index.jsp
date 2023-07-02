<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to product App</h1>
			</div>
		</div>
	</div>

	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">Sr.No</th>
				<th scope="col">Product Name</th>
				<th scope="col">Product Discription</th>
				<th scope="col">Price</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${product }" var="p">
				<tr>
					<th scope="row">${p.getId() }</th>
					<td>${p.getName() }</td>
					<td>${p.getDiscription() }</td>
					<td>${p.getPrice() }</td>
					<td><a href="delete/${p.getId()}"><i class="fa-solid fa-trash fa-shake" style="color: #f90606;"></i></a></td>
					<td><a href="update/${p.getId()}"><i class="fa-solid fa-pen-to-square fa-bounce" style="color: #0055ff;"></i></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="container text-center">

		<a href="add-product" class="btn btn-outline-success">Add Product</a>

	</div>

</body>
</html>
