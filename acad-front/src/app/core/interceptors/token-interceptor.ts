import { HttpInterceptorFn } from '@angular/common/http';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  //const token = localStorage.getItem('token');
  const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFbHZpc0RCQSIsImlkIjoxMywiaWF0IjoxNzUxMzM2Mjk2LCJleHAiOjE3NTEzMzk4OTZ9.Enf2ARma9AIbvCWZLd-DZ3Swd4_E2j4M5WAhj3QUMUw";

  if (token) {
    const authReq = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
    return next(authReq);
  }

  return next(req);
};
