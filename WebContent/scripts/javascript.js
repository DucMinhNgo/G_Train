function fileValidation(){
var fileInput = document.getElementById('file');
var filePath = fileInput.value;//lấy giá trị input theo id
var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;//các tập tin cho phép
//Kiểm tra định dạng
if(!allowedExtensions.exec(filePath)){
alert('Please upload files have form : .jpeg/.jpg/.png/.gif only.');
fileInput.value = '';
return false;
}else{
	alert(fileInput.value);
//Image preview
if (fileInput.files && fileInput.files[0]) {
var reader = new FileReader();

reader.onload = function(e) {
	
document.getElementById('imagePreview').innerHTML = '<img style="width:700px;height:400px;" src="'+e.target.result+'"/>';
};
reader.readAsDataURL(fileInput.files[0]);
}
}
}
