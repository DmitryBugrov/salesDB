//var products;

var productView = new Vue({
        el: '#products',
        data: getProducts()
    });

$( document ).ready(function() {


    $("#add").click(
		function(){

            var d=$('#add_form')
			$.post({
                    url:     "http://127.0.0.1:8080/product/add",
                    type:     "POST",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    crossDomain: true,
                    data: JSON.stringify({'name':$("input[name='name']").val(),
                        'price':$("input[name='price']").val(),
                        'discount':$("input[name='discount']").val()}),
                    success: function(response) {
                    	$('#result_form').html('Наименование: '+response.name+'<br>Цена: '+response.price);
                	},
                	error: function(response) {
                        $('#result_form').html('Ошибка. Данные не отправлены: ');
                	}
             	});
            productView.data=getProducts();
			return false;
		}
	);
});



function getProducts() {
     $.get({
        url: '/product/all',
        success: function(response) {
            return response;
            }
     });
}