function cancel(id,uyeId,ucusId){
    Swal.fire({
  title: "<h2 style='color:lightskyblue'>Bileti İptal Etmek İstediğinize Emin Misiniz ?</h2>",
  icon: 'warning',
  background: 'navy',
  showCancelButton: true,
  confirmButtonColor: 'darkgreen',
  cancelButtonColor: 'goldenrod',
  fontSize: '800px',
  confirmButtonText: 'Evet, Eminim',
  cancelButtonText: 'Çıkış'
}).then((result) => {
  if (result.isConfirmed) {
      window.location.href = '../ticket?selector=delete&id='+id+'&uyeId='+uyeId+'&redirect=user&ucusId='+ucusId+'';
  }
});
}