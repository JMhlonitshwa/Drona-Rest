/**
 * 
 */
$(document).ready(function(){
    $('.textBox').each(function(){
         
        this.value = $(this).attr('title');
        $(this).addClass('text-label');
     
        $(this).focus(function(){
            if(this.value == $(this).attr('title')) {
                this.value = '';
                $(this).removeClass('text-label');
            }
        });
     
        $(this).blur(function(){
            if(this.value == '') {
                this.value = $(this).attr('title');
                $(this).addClass('text-label');
            }
        });
    });
    $("#login").click(function(){
    	alert("hi");
    });
    
});
    