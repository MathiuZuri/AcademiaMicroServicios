import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./category/dashboard/dashboard.component').then((m) => m.DashboardComponent),
    children:[
      {
        path: 'apoderado',
        loadComponent: () =>
          import('./category/apoderado/apoderado').then((m) => m.Apoderado),
      },
      {
        path: 'apoderado/editar/:id',
        loadComponent: () =>
          import('./category/apoderado/edit/edit-apoderado.component')
            .then((m) => m.EditApoderadoComponent),
      },
      {
        path: 'apoderado/nuevo',
        loadComponent: () =>
          import('./category/apoderado/new/new-apoderado.component').then(m => m.NewApoderadoComponent)
      },
      {
        path: '',
        redirectTo: 'apoderado',
        pathMatch: 'full',
      }

    ]
  }

];
