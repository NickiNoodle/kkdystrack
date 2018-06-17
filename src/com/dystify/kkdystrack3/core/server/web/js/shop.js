$(document).ready(() => {
  $('.addItem').on('click', () => {
    let name = $('.name').val();
    if (name.length != 0) {
      $.ajax({
        type: "POST",
        url: "/shop/add",
        data: JSON.stringify({"name": name}),
        success: (data) => {
          console.log(data);
        },
        contentType: "application/json"
      });
    }
  });
});