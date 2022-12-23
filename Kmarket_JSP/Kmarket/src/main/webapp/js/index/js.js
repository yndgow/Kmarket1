/**
 * 
 */
  $(document).ready(function(){
          $(".slider > ul").bxSlider({
            easing: "linear",
          });
          
          /* 스크롤 이동 */
          $('.scrollBtnHit').on('click', function(e){
        	  e.preventDefault();
        	  let location = document.querySelector("#hit").offsetTop;

        	  window.scrollTo({top:location, behavior:'smooth'});
        	  
          });
          $('.scrollBtnScore').on('click', function(e){
        	  e.preventDefault();
        	  let location = document.querySelector("#score").offsetTop;

        	  window.scrollTo({top:location, behavior:'smooth'});
        	  
          });
          $('.scrollBtnNew').on('click', function(e){
        	  e.preventDefault();
        	  let location = document.querySelector("#new").offsetTop;

        	  window.scrollTo({top:location, behavior:'smooth'});
        	  
          });
          $('.scrollBtnDis').on('click', function(e){
        	  e.preventDefault();
        	  let location = document.querySelector("#dis").offsetTop;

        	  window.scrollTo({top:location, behavior:'smooth'});
        	  
          });
          
        });
        $(function(){
            let best = $("aside > .best");
            
            $(window).scroll(function(){

              let t = $(this).scrollTop();

              if(t > 620){
                best.css({
                  position: "fixed",
                  top: "0",
                });
              }else{
                best.css({position: "static"});
              }
            });
        });