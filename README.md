(function(){
    var w=window, C='___grecaptcha_cfg', cfg=w[C]=w[C]||{}, N='grecaptcha';
    var gr=w[N]=w[N]||{};
    gr.ready=gr.ready||function(f){(cfg['fns']=cfg['fns']||[]).push(f);};

    w['__recaptcha_api']='https://www.google.com/recaptcha/api2/';
    (cfg['render']=cfg['render']||[]).push('onload');
    (cfg['clr']=cfg['clr']||[]).push('true');
    (cfg['anchor-ms']=cfg['anchor-ms']||[]).push(20000);
    (cfg['execute-ms']=cfg['execute-ms']||[]).push(15000);
    w['__google_recaptcha_client']=true;

    var d=document, po=d.createElement('script');
    po.type='text/javascript';
    po.async=true;
    po.charset='utf-8';
    // REMOVE META injection (LWS blocks it)
    po.src='https://www.gstatic.com/recaptcha/releases/XrIDux0s7SoNe6_IHkjGC92W/recaptcha__en.js';
    po.crossOrigin='anonymous';
    po.integrity='sha384-QqfebjEuIgnKX+GxU4cN+byIJWmt6PLd1Lhx1lDrZnC9qHnUqKxROgib38rfVJzS';

    var e=d.querySelector('script[nonce]'), n=e&&(e['nonce']||e.getAttribute('nonce'));
    if(n){ po.setAttribute('nonce', n); }

    var s=d.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
})();
