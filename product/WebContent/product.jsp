<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
<style>
   main {
      width: 50%;
      margin: 0 auto;
   }
   div{
   margin : 0 auto;
   text-align: center;
   	
   }
   
  #products{
   margin : 0 auto;
   text-align: center;
   }
   
</style>
</head>
<body>
   <main>
      <h1>상품 관리</h1>
      <!-- 추가 -->
      <div style="width: 100%; text-align: right">
         <a href="javascript:view()">추가</a>
         <div class="input-wrap" style="width: 100%; text-align: center; display: none;">
            <input type="text" name="productName" placeholder="상품 이름">
            <input type="text" name="productPrice" placeholder="상품 가격">
            <input type="text" name="productStock" placeholder="상품 재고">
            <input type="button" value="상품 등록" style="width: 70%" onclick="insert()">
         </div>
         <div style="padding-top:30px">상품목록
	         <table  border="1" id="products">
	         </table>
         </div>
         <!-- 목록 -->
         <!-- 상품별 수정, 삭제 -->
      </div>
   </main>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
   let count = 1;
   
   print();
   
	 function view(){
	      $(".input-wrap").slideToggle(function(){
	         count *= -1;
	         $(this).prev().text(count > 0 ? "추가" : "닫기");
	      });
   }
   
      
   function insert(){
      const $productNameInput = $("input[name='productName']");
      const $productPriceInput = $("input[name='productPrice']");
      const $productStockInput = $("input[name='productStock']");
      
      if(!$productNameInput.val()){
         $productNameInput.focus();
         return;
      }
      if(!$productPriceInput.val()){
         $productPriceInput.focus();
         return;
      }
      if(!$productStockInput.val()){
         $productStockInput.focus();
         return;
      }
      
      $.ajax({
         url: "${pageContext.request.contextPath}/create.prod",
         type: "post",
         data: {productName: $productNameInput.val(), productPrice: $productPriceInput.val(), productStock: $productStockInput.val()},
         success: function(){
            $productNameInput.val("");
            $productPriceInput.val("");
            $productStockInput.val("");
            
            print();
         }
      });
   }
   
   function print() {
      $.ajax({
         url: "${pageContext.request.contextPath}/printOk.prod",
         type: "get",
         contentType: "application/json; charset=utf-8",
         dataType:'json',
         success: printList
      });
   }
   
   function printList(products) {
	   if(products.length > 0){
			let text = "";
			
				text += `<tr>`;
				text += `<th>상품번호</th>`;
				text += `<th>상품이름</th>`;
				text += `<th>상품가격</th>`;
				text += `<th>상품재고</th>`;
				text += `<th>서비스</th>`;
				text += `</tr>`; 
			products.forEach(product => {
				text += `<tr>`;
				text += `<td> `+ product.productNumber +` </td>`;
				text += `<td>` + product.productName +` </td>`;
				text += `<td> `+ product.productPrice +` </td>`;
				text += `<td> `+ product.productStock +` </td>`;
                text += `<td><a href="javascript:void(0);">수정</a></td>`;
                text += `<td><a href="javascript:void(0);">삭제</a></td>`;

				text += `</tr>`;
			});
			$('#products').html(text);
	   }
}
      
</script>
</html>



