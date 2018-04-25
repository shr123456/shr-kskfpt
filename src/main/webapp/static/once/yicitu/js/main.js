$(function(){
	
	size();
	
	$(window).resize(function() {
		
		size();
		
	});
	
	function size(){
		var aW = $('.cri_main').width(),
				h = aW * 0.20,
				p = aW * 0.0852;
		
		$('.img_x td').height(h);
		$('.img_pad').css('padding-top', p + 'px');
		
	}
	
})