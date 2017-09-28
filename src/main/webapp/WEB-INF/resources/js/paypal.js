paypal.Button.render({
    env: 'sandbox',

    style: {
        label: 'checkout',  // checkout | credit | pay | buynow | generic
        size:  'responsive', // small | medium | large | responsive
        shape: 'pill',   // pill | rect
        color: 'gold'   // gold | blue | silver | black
    },

    client: {
        sandbox:    'AUwwHSf-0z1e0-Sk36dD2wOOoP49aNLKQoJip3i8ap44I1MmiuIW1emwCMO6Io1VCJkIGA92ml-UcSBj'
    },
    commit: true,
    payment: function(data, actions) {
        return actions.payment.create({
            payment: {
                transactions: [
                    {
                        amount: { total: '0.01', currency: 'USD' }
                    }
                ]
            }
        });
    },

    // onAuthorize() is called when the buyer approves the payment
    onAuthorize: function(data, actions) {

        // Make a call to the REST api to execute the payment
        return actions.payment.execute().then(function() {
            window.alert('Payment Complete!');
        });
    }

}, '#paypal-button-container');
