function FillShiiping(f) {
    if (f.copyAddress.checked == true) {
        f.shippingAddressLine1.value = f.billingAddressLine1.value;
        f.shippingAddressLine2.value = f.billingAddressLine2.value;
        f.shippingCity.value = f.billingCity.value;
        f.shippingState.value = f.billingState.value;
        f.shippingCountry.value = f.billingCountry.value;
        f.shippingPinCode.value = f.billingPinCode.value;
    }
}
