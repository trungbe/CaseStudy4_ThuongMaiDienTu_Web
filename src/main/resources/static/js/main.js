// //$(":input").bind('click', function (e) {
// //    e.preventDefault();
// //    $('#coupon_code').val(600);
// //
// //});
//
// jQuery(document).ready(function ($) {
//
//     // jQuery sticky Menu
//     $("#usernameForCart").val($("#username").html())
//     $(".usernameForDetail").val($("#username").html())
//     $(".mainmenu-area").sticky({topSpacing: 0});
//
//
//     $('.product-carousel').owlCarousel({
//         loop: true,
//         nav: true,
//         margin: 20,
//         responsiveClass: true,
//         responsive: {
//             0: {
//                 items: 1,
//             },
//             600: {
//                 items: 3,
//             },
//             1000: {
//                 items: 5,
//             }
//         }
//     });
//
//     $('.related-products-carousel').owlCarousel({
//         loop: true,
//         nav: true,
//         margin: 20,
//         responsiveClass: true,
//         responsive: {
//             0: {
//                 items: 1,
//             },
//             600: {
//                 items: 2,
//             },
//             1000: {
//                 items: 2,
//             },
//             1200: {
//                 items: 3,
//             }
//         }
//     });
//
//     $('.brand-list').owlCarousel({
//         loop: true,
//         nav: true,
//         margin: 20,
//         responsiveClass: true,
//         responsive: {
//             0: {
//                 items: 1,
//             },
//             600: {
//                 items: 3,
//             },
//             1000: {
//                 items: 4,
//             }
//         }
//     });
//
//
//     // Bootstrap Mobile Menu fix
//     $(".navbar-nav li a").click(function () {
//         $(".navbar-collapse").removeClass('in');
//     });
//
//     // jQuery Scroll effect
//     $('.navbar-nav li a, .scroll-to-up').bind('click', function (event) {
//         var $anchor = $(this);
//         var headerH = $('.header-area').outerHeight();
//         $('html, body').stop().animate({
//             scrollTop: $($anchor.attr('href')).offset().top - headerH + "px"
//         }, 1200, 'easeInOutExpo');
//
//         event.preventDefault();
//     });
//
//     // Bootstrap ScrollPSY
//     $('body').scrollspy({
//         target: '.navbar-collapse',
//         offset: 95
//     })
// });
//
// (function (i, s, o, g, r, a, m) {
//     i['GoogleAnalyticsObject'] = r;
//     i[r] = i[r] || function () {
//         (i[r].q = i[r].q || []).push(arguments)
//     }, i[r].l = 1 * new Date();
//     a = s.createElement(o),
//         m = s.getElementsByTagName(o)[0];
//     a.async = 1;
//     a.src = g;
//     m.parentNode.insertBefore(a, m)
// })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
//
// ga('create', 'UA-10146041-21', 'auto');
// ga('send', 'pageview');
//
// function getUsername(e) {
//     var username = $("#username").html();
// }
//
// var countt = 0;
// for (let i = 0; i < cart.length; i++) {
//     countt += cart[i].quantity;
// }
// $("#numberCart").html("Giỏ hàng (" + countt + ")")
//
// function addToCart(e, elem) {
//     e.preventDefault();
//     var id = Number($(elem).attr("value"));
//     var quantityProduct = Number($(elem).attr("id"));
//     if (quantityProduct == 0) {
//         alert("Sản phẩm này đã hết hàng!")
//         return;
//     }
//     for (let i = 0; i < cart.length; i++) {
//         if (cart[i].id == id && cart[i].quantity == quantityProduct) {
//             alert("Sản phẩm này đã hết hàng!")
//             return;
//         }
//     }
//     var count = 0;
//     for (let i = 0; i < cart.length; i++) {
//         count += cart[i].quantity;
//     }
//
//     var data = {};
//     var username = $("#username").html();
//     data['username'] = username;
//     data['productId'] = id;
//     data['quantity'] = 1;
//     data['_csrf'] = $('input[name="_csrf"]').attr('value')
//     let a = {username: username, id: id, quantity: 1}
//     $.ajax({
//         url: "/api/addCart",
//         type: "POST",
//         dataType: "json",
//         data: JSON.stringify(data),
//         contentType: "application/json",
//         xhrFields: {
//             withCredentials: true
//         },
//         success: function (response) {
//             console.log("success");
//         },
//         error: function (response) {
//             console.log("fail");
//         }
//     });
//     for (let x = 0; x < cart.length; x++) {
//         if (cart[x].id == Number(id)) {
//             cart[x].quantity = cart[x].quantity + 1;
//             let productId = []
//             let quantity = []
//             for (var i = 0; i < cart.length; i++) {
//                 productId.push(cart[i].id)
//                 quantity.push(cart[i].quantity)
//             }
//             $.cookie('productId', JSON.stringify(productId), {expires: 7, path: '/'});
//             $.cookie('quantity', JSON.stringify(quantity), {expires: 7, path: '/'});
//             $("#numberCart").html("Giỏ hàng (" + (count + 1) + ")")
//             return
//         }
//     }
//     cart.push(a)
//     // updateCookies();
//     let productId = []
//     let quantity = []
//     for (var i = 0; i < cart.length; i++) {
//         productId.push(cart[i].id)
//         quantity.push(cart[i].quantity)
//     }
//     $.cookie('productId', JSON.stringify(productId), {expires: 7, path: '/'});
//     $.cookie('quantity', JSON.stringify(quantity), {expires: 7, path: '/'});
//     $("#numberCart").html("Giỏ hàng (" + (count + 1) + ")")
//
// }
//
//
// function forgotLogin() {
//     window.location = "/login?unknowuser";
// }
//
//
// $.ajaxSetup({
//     beforeSend: function (xhr, settings) {
//         if (settings.type == 'POST' || settings.type == 'PUT' || settings.type == 'DELETE') {
//             var token = $('input[name="_csrf"]').attr('value')
//             if (!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
//                 // Only send the token to relative URLs i.e. locally.
//                 xhr.setRequestHeader("X-CSRF-Token", token);
//             }
//         }
//     }
// });
// $(document).ready(function () {
//     $('li.active').removeClass('active');
//     $('a[href="' + location.pathname + '"]').closest('li').addClass('active');
// });
