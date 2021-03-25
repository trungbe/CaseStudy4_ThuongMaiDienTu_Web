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


//hung
(function ($) {
    "use strict";

    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 768) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });


    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Header slider
    $('.header-slider').slick({
        autoplay: true,
        dots: true,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1
    });


    // Product Slider 4 Column
    $('.product-slider-4').slick({
        autoplay: true,
        infinite: true,
        dots: false,
        slidesToShow: 4,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 4,
                }
            },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 3,
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1,
                }
            },
        ]
    });


    // Product Slider 3 Column
    $('.product-slider-3').slick({
        autoplay: true,
        infinite: true,
        dots: false,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 3,
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1,
                }
            },
        ]
    });


    // Product Detail Slider
    $('.product-slider-single').slick({
        infinite: true,
        autoplay: true,
        dots: false,
        fade: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        asNavFor: '.product-slider-single-nav'
    });
    $('.product-slider-single-nav').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        dots: false,
        centerMode: true,
        focusOnSelect: true,
        asNavFor: '.product-slider-single'
    });


    // Brand Slider
    $('.brand-slider').slick({
        speed: 5000,
        autoplay: true,
        autoplaySpeed: 0,
        cssEase: 'linear',
        slidesToShow: 5,
        slidesToScroll: 1,
        infinite: true,
        swipeToSlide: true,
        centerMode: true,
        focusOnSelect: false,
        arrows: false,
        dots: false,
        responsive: [
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 4,
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 3,
                }
            },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 300,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });


    // Review slider
    $('.review-slider').slick({
        autoplay: true,
        dots: false,
        infinite: true,
        slidesToShow: 2,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });


    // Widget slider
    $('.sidebar-slider').slick({
        autoplay: true,
        dots: false,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1
    });


    // Quantity
    $('.qty button').on('click', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find('input').val(newVal);
    });


    // Shipping address show hide
    $('.checkout #shipto').change(function () {
        if($(this).is(':checked')) {
            $('.checkout .shipping-address').slideDown();
        } else {
            $('.checkout .shipping-address').slideUp();
        }
    });


    // Payment methods show hide
    $('.checkout .payment-method .custom-control-input').change(function () {
        if ($(this).prop('checked')) {
            var checkbox_id = $(this).attr('id');
            $('.checkout .payment-method .payment-content').slideUp();
            $('#' + checkbox_id + '-show').slideDown();
        }
    });
})(jQuery);

