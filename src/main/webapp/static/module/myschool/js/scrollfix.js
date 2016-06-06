$(function(){
	$(window).scroll(function() {
			if($(window).scrollTop() > 120){
					$('.left-wrap').addClass('fix-scroll');
			}else{
					$('.left-wrap').removeClass('fix-scroll');
			}
	});
});