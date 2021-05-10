let listfeedback = [];

const renderData = function () {
    db.collection('new_reg').get().then(data => {

        data.docs.forEach(element => {
            const comment = element.data();
            listfeedback.push(comment);
        });

        listfeedback.forEach(element => {

            $('.tabeldata').append('<tr><td>'+element.CustName+'</td><td>'+element.Address+'</td><td>'+element.Email+'</td><td>'+element.PhoneNo+'</td><td>'+element.Pincode+'</td></tr>');
        });

    });
}


renderData();

