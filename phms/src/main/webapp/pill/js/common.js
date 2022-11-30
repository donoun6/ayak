'use strict'
$(function(){
  $(".on2").click(function(){
    $(".first").css("display","none").css("opacity","0");
    $(".second").css("display","block").css("opacity","1");
  });

  $(".on1").click(function(){
    $(".second").css("display","none").css("opacity","0");
    $(".first").css("display","block").css("opacity","1");
  });

});
