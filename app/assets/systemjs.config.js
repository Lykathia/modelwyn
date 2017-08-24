(function (global) {
  System.config({
    paths: {
      'npm': 'assets/lib/'
    },
    map: {
      'app': 'assets/app',
      '@angular/core': 'npm:angular__core/bundles/core.umd.js',
      '@angular/common': 'npm:angular__common/bundles/common.umd.js',
      '@angular/compiler': 'npm:angular__compiler/bundles/compiler.umd.js',
      '@angular/platform-browser': 'npm:angular__platform-browser/bundles/platform-browser.umd.js',
      '@angular/platform-browser-dynamic': 'npm:angular__platform-browser-dynamic/bundles/platform-browser-dynamic.umd.js',
      '@angular/http': 'npm:angular__http/bundles/http.umd.js',
      '@angular/router': 'npm:angular__router/bundles/router.umd.js',
      '@angular/forms': 'npm:angular__forms/bundles/forms.umd.js',
      'rxjs': 'npm:rxjs',
    },
    packages: {
      app: {
        defaultExtension: 'js',
        meta: {
          './*.js': {
              loader: 'assets/systemjs-angular-loader.js'
            }
          }
        },
        rxjs: {
          defaultExtension: 'js'
        }
      }
    });

    System.import('assets/app/main.js').catch(function(error) { console.error(error); });
})(this);
