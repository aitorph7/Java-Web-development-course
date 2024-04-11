import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { jwtInterceptor } from './authentication/jwt.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    // configuracón GLOBAL de HttpClient con interceptor JWT:
    // (ya no hace falta import de 'HttpClientModule' en los componentes.)
    provideHttpClient(withInterceptors([jwtInterceptor]))
  
  ]
};
