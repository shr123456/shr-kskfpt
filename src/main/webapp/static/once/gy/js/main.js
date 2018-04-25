$(function(){
	
	size();
	
	$(window).resize(function() {
		
		size();
		
	});
	
	function size(){
		var aW = $('.cri_main').width(),
				h = aW * 0.1785,
				p = aW * 0.0737;
		
		$('.img_x td').height(h);
		$('.img_pad').css('padding-bottom', p + 'px');
		
	}
	
})