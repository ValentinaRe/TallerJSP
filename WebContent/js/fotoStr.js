function encodeImage(){
        /*
        obtiene la imagen desde el input, para posteriormente procesarla 
        usando FileReader y encodear' la imagen en base64
        */
        var filesSelected = document.getElementById("fotoCont").files;
        if (filesSelected.length > 0)
        {
            var fileToLoad = filesSelected[0];

            var fileReader = new FileReader();// para leer el contenido de fileToLoad

            //onloadstart, onloadprogress, onload, onloadend
            fileReader.onload = function(fileLoadedEvent) {
                var srcData = fileLoadedEvent.target.result; // <--- data:image base64

                var newImage = document.createElement('img'); //elemento img
                newImage.src = srcData;

                document.getElementById("imgContainer").innerHTML = newImage.outerHTML;
                //document.getElementById("imgTest").innerHTML);
                document.getElementById("textArea").innerHTML = newImage.src;
            }
            fileReader.readAsDataURL(fileToLoad);
        }
    }



        
       
/*
function convertFileToDataURLviaFileReader(url, callback){
    var xhr = new XMLHttpRequest();
    xhr.responseType = 'blob';
    xhr.onload = function() {
        var reader  = new FileReader();
        reader.onloadend = function () {
            callback(reader.result);
        }
        reader.readAsDataURL(xhr.response);
    };
    xhr.open('GET', url);
    xhr.send();
}

$('#img2b64').submit(function(event){
    var imageUrl = $(this).find('[name=url]').val();
    var convertType = $(this).find('[name=convertType]').val();    
    var convertFunction = convertType === 'FileReader' ?  
        convertFileToDataURLviaFileReader : 
        convertImgToDataURLviaCanvas;
    
    convertFunction(imageUrl, function(base64Img){
        $('.output')
            .find('.textbox')
                .val(base64Img)
                .end()
            .find('.link')
                .attr('href', base64Img)
                .text(base64Img)
                .end()
            .find('.img')
                .attr('src', base64Img)
                .end()
            .find('.size')
                .text(base64Img.length)
                .end()
            .find('.convertType')
                .text(convertType)
                .end()
            .show()
    });
    
    event.preventDefault();
});*/




